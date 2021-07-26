package com.tian.controller;

import com.tian.dao.UserDao;
import com.tian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/index")
    public String index(){
        return "欢迎来到User的CRUD操作页面！";
    }

    @RequestMapping("/list")
    public List<User> list(){
        return userDao.listAll();
    }

    @RequestMapping("/select")
    public User select(int id){
        return userDao.selectById(id);
    }

    @RequestMapping("/update")
    public String update(User user){
        userDao.update(user);
        return "更新用户信息成功！";
    }

    @RequestMapping("/add")
    public String add(User user){
        userDao.add(user);
        return "添加用户信息成功！";
    }

    @GetMapping ("/delete")
    public String delete(int id){
        userDao.deleteById(id);
        return "删除用户信息成功！";
    }


}
