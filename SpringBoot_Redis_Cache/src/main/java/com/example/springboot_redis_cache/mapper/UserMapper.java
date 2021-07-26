package com.example.springboot_redis_cache.mapper;

import com.example.springboot_redis_cache.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> list();

    @Select("select * from user where id = #{id}")
    User select(long id);

    @Insert("insert into user value(id,username,password)")
    int add(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    int update(User user);

    @Delete("delete from user where id=#{id}")
    int delete(int id);
}
