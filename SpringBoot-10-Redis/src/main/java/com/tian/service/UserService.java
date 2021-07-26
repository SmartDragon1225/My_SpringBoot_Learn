package com.tian.service;

import com.tian.mapper.UserMapper;
import com.tian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "user")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> listAll(){
        System.out.println("查询全部用户！");
        return userMapper.listAll();
    }

    @Cacheable(key ="#p0")
    public User selectById(int id){
        System.out.println("根据用户id查询！");
        return userMapper.selectById(id);
    }

    @CachePut(key = "#p0")
    public void update(User user){
        System.out.println("更新用户信息！");
        userMapper.update(user);
    }

    //如果指定为 true，则方法调用后将立即清空所有缓存
    @CacheEvict(key ="#p0",allEntries=true)
    public void delete(int id) {
        System.out.println("根据id删除用户！");
        userMapper.delete(id);
    }

    public void add(User user){
        System.out.println("增加一个用户！");
        userMapper.add(user);
    }
}
