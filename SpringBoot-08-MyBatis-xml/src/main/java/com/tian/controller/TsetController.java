package com.tian.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/boos")
public class TsetController {
    @RequestMapping("/b")
    public String index(){
        return "index";
    }
}
