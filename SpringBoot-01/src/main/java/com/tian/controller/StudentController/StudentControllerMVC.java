package com.tian.controller.StudentController;
import com.tian.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//获取对象的方法
@Controller
public class StudentControllerMVC {
    @RequestMapping("/studentmvc")
    public ModelAndView student(){
         //实例化对像
        Student student = new Student();
        student.setId(22);
        student.setName("田智龙");
        //定义mvc中的视图模板对应的html网页
        ModelAndView modelAndView = new ModelAndView("studentmvc");
        modelAndView.addObject("student",student);
        return modelAndView;
    }

}
