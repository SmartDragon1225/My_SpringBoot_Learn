package com.example.springboot_redis_cache.servie;

import com.example.springboot_redis_cache.mapper.UserMapper;
import com.example.springboot_redis_cache.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;

    public List<User> list(){
        return userMapper.list();
    }

    /**
     * 获取用户策略：先从缓存中获取用户，没有则取数据表中 数据，再将数据写入缓存
     */
    public User select(long id) {
        String key = "user_" + id;

        ValueOperations<String, User> operations = redisTemplate.opsForValue();

        //判断redis中是否有键为key的缓存
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            User user = operations.get(key);
            System.out.println("从缓存中获得数据："+user.getUsername());
            System.out.println("------------------------------------");
            return user;
        } else {
            User user = userMapper.select(id);
            System.out.println("查询数据库获得数据："+user.getUsername());
            System.out.println("------------------------------------");

            // 写入缓存(5小时)
            operations.set(key, user, 5, TimeUnit.HOURS);
            return user;
        }
    }

    public User query(long id){
        String str = id+"";
        ValueOperations<String,User> valueOperations = redisTemplate.opsForValue();
        boolean key = redisTemplate.hasKey(str);
        if(key){          //如果缓存有值
            User user = valueOperations.get(str);
            return user;  //直接从缓存拿
        }else {           //如果缓存没有值，就从数据库查
            User user = userMapper.select(id);
            valueOperations.set(str,user);
            return user;
        }

    }

    public int insert(User user){
        int result = userMapper.add(user);
        return result;
    }

    /**
     * 更新用户策略：先更新数据表，成功之后，删除原来的缓存，再更新缓存
     */
    public int updateUser(User user) {
        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        int result = userMapper.update(user);
        if (result != 0) {
            String key = "user_" + user.getId();
            boolean haskey = redisTemplate.hasKey(key);
            if (haskey) {
                redisTemplate.delete(key);
                System.out.println("删除缓存中的key-----------> " + key);
            }
            // 再将更新后的数据加入缓存
            User userNew = userMapper.select(user.getId());
            if (userNew != null) {
                operations.set(key, userNew, 3, TimeUnit.HOURS);
            }
        }
        return result;
    }

    /**
     * 删除用户策略：删除数据表中数据，然后删除缓存
     */
    public int deleteUserById(int id) {
        int result = userMapper.delete(id);
        String key = "user_" + id;
        if (result != 0) {
            boolean hasKey = redisTemplate.hasKey(key);
            if (hasKey) {
                redisTemplate.delete(key);
                System.out.println("删除了缓存中的key:" + key);
            }
        }
        return result;
    }

}
