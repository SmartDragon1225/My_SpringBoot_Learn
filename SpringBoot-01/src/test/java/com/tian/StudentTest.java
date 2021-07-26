package com.tian;

import com.tian.controller.StudentController.StudentController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentTest {
    //获取配置文件中的age
    @Value("${id}")
    private int id;

    //获取配置文件中的name
    @Value("${name}")
    private String name;


    @Test
    public void getId() {
        System.out.println(id);
    }

    @Test
    public void getName() {
        System.out.println(name);
    }

    @Autowired
    private StudentController getPersonInfoProperties;
    @Test
    public void getPersonproperties() {
        System.out.println(getPersonInfoProperties.getName()+" "+
                getPersonInfoProperties.getId());
    }
}
