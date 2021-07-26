package com.example.springboot_redis_cache.controller;

import com.example.springboot_redis_cache.pojo.User;
import com.example.springboot_redis_cache.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/list")
    public List<User> list(){
        return userService.list();
    }

    @RequestMapping("/findUserById")
    public Map<String, Object> findUserById(@RequestParam int id){
        User user = userService.select(id);
        Map<String, Object> result = new HashMap<>();
        result.put("uid", user.getId());
        result.put("uname", user.getUsername());
        result.put("pass", user.getPassword());
        return result;
    }

    @RequestMapping("/select/{id}")
    public User select(@PathVariable("id") long id){
        return userService.select(id);
    }

    @RequestMapping("/query/{id}")
    public User query(@PathVariable("id") long id){
        return userService.query(id);
    }//update?id=4,username=打瞌睡,password=13232

    @RequestMapping("/updateUser")
    public String updateUser(){
        User user = new User();
        user.setId(1);
        user.setUsername("cat");
        user.setPassword("miaomiao");

        int result = userService.updateUser(user);

        if(result != 0){
            return "update user success";
        }

        return "fail";
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam int id){
        int result = userService.deleteUserById(id);
        if(result != 0){
            return "delete success";
        }
        return "delete fail";
    }

    @RequestMapping("/insert")
    public String add(User user){
        userService.insert(user);
        return "add ok!";
    }
}
