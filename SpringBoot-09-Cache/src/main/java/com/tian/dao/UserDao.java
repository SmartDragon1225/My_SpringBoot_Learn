package com.tian.dao;

import com.tian.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> listAll();

    User selectById(int id);

    int add(User user);

    int deleteById(int id);

    int update(User user);
}
