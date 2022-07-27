package com.chenyuhui.mybatis.mapper;

import com.chenyuhui.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SpecialMapper {

    //模糊查询
    List<User> testMohu(@Param("mohu") String mohu);

    //批量删除
    void testDelete(@Param("ids") String ids);

    //动态设置表明
    List<Map<String,Object>> getAllData(@Param("tableName") String tableName);

    /*
    添加功能获取自增的主键
    useGeneratedKeys：设置使用自增的主键
    keyProperty：因为增删改有统一的返回值是受影响的行数，因此只能将获取的自增的主键放在传输的参数user对象的某个属性中
    */
    int insertUser(User user);

}
