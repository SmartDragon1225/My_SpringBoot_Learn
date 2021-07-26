package com.tian.controller.StudentController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    //获取配置文件中的id
    @Value("${id}")
    private int id;

    //获取配置文件中的name
    @Value("${name}")
    private String name;

    @RequestMapping("/getId")
    public int getId(){
         return id;
    }

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }

    @Autowired
    private StudentController studentController;
    //获取学生信息
    @RequestMapping("/getStudent")
    public String getStudent(){
        return studentController.getId()+" "+studentController.getName();
    }

}
