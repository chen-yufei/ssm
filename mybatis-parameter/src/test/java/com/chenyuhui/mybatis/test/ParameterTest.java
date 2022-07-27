package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.UserMapper;
import com.chenyuhui.mybatis.pojo.User;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ParameterTest {

    @Test
    public void testGetUserByName() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByName("root");
        System.out.println(user);
    }


    @Test
    public void testLogin() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.login("root","1111");
        System.out.println(user);
    }

    @Test
    public void testLoginByMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,String> map = new HashMap<String,String>();
        map.put("username","root");
        map.put("password","1111");
        User user = userMapper.loginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null,"xiaoming","2222",23,"男","22344@163.com");
        int result = userMapper.insertUser(user);
        System.out.println(result);
    }

    @Test
    public void testLoginByParameter() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.loginByParameter("root","1111");
        System.out.println(user);
    }



}
