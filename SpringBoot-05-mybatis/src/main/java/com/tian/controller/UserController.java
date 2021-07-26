package com.tian.controller;

import com.tian.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //创建数据表
    @GetMapping("createUserTable")
    public String createUserTable() throws Exception {
        String sql = "CREATE TABLE `usertest` (\n" +
                "  `id` int(10) NOT NULL AUTO_INCREMENT,\n" +
                "  `username` varchar(100) DEFAULT NULL,\n" +
                "  `password` varchar(100) DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`)\n" +
                ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n" +
                "\n";

        jdbcTemplate.execute(sql);
        return "创建表成功";
    }

    //saveUserTest
    //添加一个测试数据
    @GetMapping("saveUser")
    public String saveUser(){
         String sql = "insert into usertest(username,password) value ('田智鹏','123456')";
        int rows = jdbcTemplate.update(sql);
        return "执行成功，影响" + rows + "行";
    }

    //addUser?userName=longzhiran&passWord=123456
    //restful风格添加
    @GetMapping("add")
    public String addUser(String userName, String passWord) throws Exception {
        String sql = "INSERT INTO usertest (USERNAME,PASSWORD) VALUES (?,?)";
        int rows = jdbcTemplate.update(sql, userName, passWord);
        return "添加用户执行成功，影响" + rows + "行";
    }

    //restful风格添加用户
    //updateUserPassword?id=1&passWord=12345678
    @GetMapping("updateUserPassword")
    public String updateUserPassword(int id, String passWord) throws Exception {
        String sql = "UPDATE usertest SET PASSWORD = ? WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, passWord, id);
        return "密码修改执行成功，影响" + rows + "行";
    }

    //根据id删除用户
    //deleteUserById?id=1
    @GetMapping("deleteUserById")
    public String deleteUserById(int id) throws Exception {
        String sql = "DELETE FROM  usertest  WHERE ID = ?";
        int rows = jdbcTemplate.update(sql, id);
        return "删除用户执行成功，影响" + rows + "行";
    }


    //根据name查询用户
    //getUserByName?userName=longzhiran
    @GetMapping("getUserByName")
    public List getUserByName(String userName)throws Exception {
        String sql = "SELECT * FROM usertest WHERE USERNAME = ?";
        List<User> list = jdbcTemplate.query(sql, new User(), new Object[]{userName});
        return list;
    }

    //根据id查询用户
    //getMapById?id=1
    @GetMapping("getMapById")
    public Map getMapById(Integer id) throws Exception {
        String sql = "SELECT * FROM usertest WHERE ID = ?";
        Map map = jdbcTemplate.queryForMap(sql, id);
        return map;
    }

    //根据id查询用户
    //getUserById?id=1
    @GetMapping("getUserById")
    public User getUserById(Integer id) throws Exception {
        String sql = "SELECT * FROM usertest WHERE ID = ?";
        User user = jdbcTemplate.queryForObject(sql, new User(), new Object[]{id});
        return user;
    }

    //getAll获取全部用户信息
    @GetMapping("list")
    public List<User> list() throws Exception {
        String sql = "SELECT * FROM usertest";
        List<User> userList = jdbcTemplate.query(sql,
                new BeanPropertyRowMapper(User.class));
        return userList;
    }

}
