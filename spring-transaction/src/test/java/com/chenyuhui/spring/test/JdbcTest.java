package com.chenyuhui.spring.test;

import com.chenyuhui.spring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-jdbc.xml")
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testUpdate() {
        String sql = "insert into t_cyh_user values(null,?,?,?,?,?)";
        int result = jdbcTemplate.update(sql,"aaa","1111",22,"男","2234@163.com");
        System.out.println(result);
    }

    @Test
    public void testGetUserById() {
        String sql = "select * from t_cyh_user where id = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        String sql = "select * from t_cyh_user";
        List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        list.forEach(System.out::println);
    }

    @Test
    public void testGetUserCount() {
        String sql = "select count(*) from t_cyh_user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }
}
