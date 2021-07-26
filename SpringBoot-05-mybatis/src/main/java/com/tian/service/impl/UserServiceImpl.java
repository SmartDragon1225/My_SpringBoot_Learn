package com.tian.service.impl;

import com.tian.dao.UserDao;
import com.tian.pojo.User;
import com.tian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
