package com.chenyuhui.mybatis.test;

import com.chenyuhui.mybatis.mapper.SpecialMapper;
import com.chenyuhui.mybatis.pojo.User;
import com.chenyuhui.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SpecialTest {

    @Test
    public void testMohuSelect() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        List<User> list = specialMapper.testMohu("oo");
        System.out.println(list);
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        specialMapper.testDelete("6,7,8");
    }

    @Test
    public void testAllData() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        List<Map<String,Object>> list = specialMapper.getAllData("t_cyh_user");
        System.out.println(list);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SpecialMapper specialMapper = sqlSession.getMapper(SpecialMapper.class);
        User user = new User(null,"cyh","1998",23,"男","22343@qq.com");
        specialMapper.insertUser(user);
        System.out.println(user);
    }

}
