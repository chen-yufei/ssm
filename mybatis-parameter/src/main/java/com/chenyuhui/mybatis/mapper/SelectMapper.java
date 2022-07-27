package com.chenyuhui.mybatis.mapper;

import com.chenyuhui.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    //查询一个实体类对象
    User getUserById(@Param("id") int id);

    //查询一个list集合
    List<User> getAllUser();

    //查询单个数据
    int getTotalUserCount();

    //查询一条数据为map集合
    Map<String,Object> getUserToMap(@Param("id") int id);

    //查询多条数据为map集合  方式一：
    List<Map<String,Object>> getAllUserToMap();

    //查询多条数据为map集合  方式二：
    /*
    将表中的数据以map集合的方式查询，一条数据对应一个map；若有多条数据，就会产生多个map集合，
    并且最终要以一个map的方式返回数据，此时需要通过@MapKey注解设置map集合的键，值是每条数据所对应的map集合
    */
    @MapKey("id")
    Map<String,Object> getUsersToMap();



}
