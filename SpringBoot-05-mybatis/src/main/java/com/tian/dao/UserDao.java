package com.tian.dao;

import com.tian.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User login(User user);
}
