package com.tian;

import com.tian.dao.UserDao;
import com.tian.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBoot08MyBatisXmlApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    void contextLoads() {
        userDao.listAll().forEach(System.out::println);
    }
    @Test
    public void select(){
        System.out.println(userDao.selectById(2));
    }

    @Test
    public void add(){
        userDao.add(new User(6,"是分开计算","3213213"));
    }

    @Test
    public void del(){
        userDao.deleteById(5);
    }

    @Test
    public void update(){
        userDao.update(new User(1,"翔龙龙","2523061"));
        userDao.listAll().forEach(System.out::println);
    }

}
