package com.chenyuhui.mybatis.mapper;


import com.chenyuhui.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    int insertUser();

    int deleteUser();

    int updateUser();

    User selectUserById();

    List<User> selectAllUser();
}
