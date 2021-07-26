package com.tian.controller;

import com.tian.mapper.UserMapper;
import com.tian.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserTsxt {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void list(){
        List<User> userList = userMapper.listAll();
        for (User user:userList)
            System.out.println(user);
    }

    @Test
    public void add(){
        userMapper.add(new User(5,"文科积","1222"));
    }

}

