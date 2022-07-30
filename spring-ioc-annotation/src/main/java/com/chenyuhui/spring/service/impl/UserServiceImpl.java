package com.chenyuhui.spring.service.impl;

import com.chenyuhui.spring.dao.UserDao;
import com.chenyuhui.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public void saveUser() {
        userDao.saveUser();
    }
}
