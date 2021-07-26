package com.tian.controller.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class HJ {
    @RequestMapping("/i")
    String index(){
        return "hello";
    }
}
