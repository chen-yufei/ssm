package com.chenyuhui.spring.service.impl;

import com.chenyuhui.spring.dao.UserDao;
import com.chenyuhui.spring.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void saveUser() {
        userDao.saveUser();
    }
}
