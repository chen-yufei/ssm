package com.chenyuhui.mybatis.mapper;

import com.chenyuhui.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {

    /*
    单个字面量类型的参数
    若mapper接口中的方法参数为单个的字面量类型
    此时可以使用${}和#{}以任意的名称获取参数的值，注意${}需要手动加单引号
    */
    User getUserByName(String username);


    /*
    多个字面量类型的参数
    若mapper接口中的方法参数为多个时
    此时MyBatis会自动将这些参数放在一个map集合中，以arg0,arg1...为键，以参数为值；以
    param1,param2...为键，以参数为值；因此只需要通过${}和#{}访问map集合的键就可以获取相
    对应的值，注意${}需要手动加单引号
    */
    User login(String username,String password);


    /*
    map集合类型的参数
    若mapper接口中的方法需要的参数为多个时，此时可以手动创建map集合，将这些数据放在map中
    只需要通过${}和#{}访问map集合的键就可以获取相对应的值，注意${}需要手动加单引号
    */
    User loginByMap(Map map);

    /*
    实体类类型的参数
    若mapper接口中的方法参数为实体类对象时
    此时可以使用${}和#{}，通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
    */
    int insertUser(User user);

    /*
    使用@Param标识参数
    可以通过@Param注解标识mapper接口中的方法参数
    此时，会将这些参数放在map集合中，以@Param注解的value属性值为键，以参数为值；以
    param1,param2...为键，以参数为值；只需要通过${}和#{}访问map集合的键就可以获取相对应的值，
    注意${}需要手动加单引号
    */
    User loginByParameter(@Param("username") String username, @Param("password") String password);

}
