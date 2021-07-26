package com.tian.controller;

import com.tian.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {
    @GetMapping("/")
    /*
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }*/
    public String index(){
        return "index";
    }

    //测试在前端页面显示对象（thymeleaf的表达式（重点掌握！））
    @RequestMapping("/getStudent")
    public ModelAndView student(){
        Student student = new Student(22,"longzhonghua");
        ModelAndView modelAndView = new ModelAndView("thymeleaf");
        String name = "longzhonghua";
        Integer age=8;
        modelAndView.addObject("name", name);
        modelAndView.addObject("age", age);
        return modelAndView;
    }


    //测试在前端显示list集合（thymeleaf的表达式（重点掌握！））
    @RequestMapping("getList")
    public ModelAndView getlist(){
        List<Object> list = new ArrayList<>();
        list.add("渭南");
        list.add("北京");
        list.add("上海");
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("list",list);
        return modelAndView;
    }

    //测试在前端显示list集合（thymeleaf的表达式（重点掌握！））
    @RequestMapping("getList1")
    public ModelAndView getlist2(){
        List<Student> list = new ArrayList<>();
        list.add(new Student(22,"渭南"));
        list.add(new Student(23,"北京"));
        list.add(new Student(34,"上海"));
        ModelAndView modelAndView = new ModelAndView("list2");
        modelAndView.addObject("list2",list);
        return modelAndView;
    }

    //测试在前端显示map集合（thymeleaf的表达式（重点掌握！））
    @RequestMapping("/getMap")
    public ModelAndView getMap(){
        Map map = new HashMap();
        map.put(1,"模式打开里面的");
        map.put(2,"默多克为了买房");
        map.put(3,"多可怜");
        ModelAndView modelAndView = new ModelAndView("map");
        modelAndView.addObject("map",map);
        return modelAndView;
    }


}
