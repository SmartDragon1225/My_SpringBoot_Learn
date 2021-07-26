package com.tian.controller;

import com.tian.pojo.User;
import com.tian.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    UserService userService;
    @RequestMapping("login")
    public String login(User user){
        User user1 = userService.login(user);
        if(user1!=null){
            return "aa";
        }else {
            return "login";
        }
    }
}
