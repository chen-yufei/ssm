package com.chenyuhui.spring.dao.impl;

import com.chenyuhui.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public void saveUser() {
        System.out.println("保存成功");
    }
}
