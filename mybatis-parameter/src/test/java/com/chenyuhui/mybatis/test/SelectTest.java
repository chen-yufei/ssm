package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.SelectMapper;
import com.chenyuhui.mybatis.pojo.User;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = selectMapper.getAllUser();
        System.out.println(list);
    }

    @Test
    public void testGetTotalUserCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        int count = selectMapper.getTotalUserCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = selectMapper.getUserToMap(1);
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String,Object>> list = selectMapper.getAllUserToMap();
        System.out.println(list);
    }

    @Test
    public void testGetUsersToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String,Object> map = selectMapper.getUsersToMap();
        System.out.println(map);
    }


}
