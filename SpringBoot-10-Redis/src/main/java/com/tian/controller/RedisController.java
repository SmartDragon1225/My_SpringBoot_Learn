package com.tian.controller;

import com.tian.pojo.User;
import com.tian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class RedisController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.listAll();
    }

    @RequestMapping("/select/{id}")
    public User select(@PathVariable("id") int id){
        return userService.selectById(id);
    }

    @RequestMapping("/update")
    public String update(User user){
        userService.update(user);
        return "更新用户信息成功！";
    }

    @RequestMapping("/delete/{id}")
    public String  delete(int id){
        userService.delete(id);
        return "\"根据用户删除成功！\"";
    }

    @RequestMapping("/add")
    public String add(User user){
        userService.add(user);
        return "\"增加一个用户！\"成功！";
    }
}
