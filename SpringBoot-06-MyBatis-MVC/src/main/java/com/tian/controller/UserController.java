package com.tian.controller;

import com.tian.mapper.UserMapper;
import com.tian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/list")
    public List<User> list(){
        return userMapper.listAll();
    }

    @RequestMapping("/selectById")
    public User selectbyid(int id){
        return userMapper.selectById(id);
    }

    @RequestMapping("/add")
    String add(User user) {
        return userMapper.add(user) == 1 ? "success" : "failed";
    }

    @RequestMapping("/updatebyid")
    String updateById(User user) {
        return userMapper.updata(user) == 1 ? "success" : "failed";
    }

    @RequestMapping("/delbyid")
    String delById(int id) {
        return userMapper.delete(id) == 1 ? "success" : "failed";
    }

}
