package com.tian.controller.UserController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/index")
    public String index(){
         return "ems/login";
    }
    @GetMapping(value = "/toRegister")
    public String toRegister() {
        return "ems/regist";
    }

    @GetMapping(value = "/toSave")
    public String toSave() {
        return "ems/addEmp";
    }


}
