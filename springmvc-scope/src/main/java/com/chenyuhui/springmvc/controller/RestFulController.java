package com.chenyuhui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 就是 HTTP 协议里面，四个表示操作方式的动词：GET、POST、PUT、DELETE。

 由于浏览器只支持发送get和post方式的请求，那么该如何发送put和delete请求呢？
 SpringMVC 提供了 HiddenHttpMethodFilter 帮助我们将 POST 请求转换为 DELETE 或 PUT 请求
 HiddenHttpMethodFilter 处理put和delete请求的条件：
 a>当前请求的请求方式必须为post
 b>当前请求必须传输请求参数_method
 满足以上条件，HiddenHttpMethodFilter 过滤器就会将当前请求的请求方式转换为请求参数
 _method的值，因此请求参数_method的值才是最终的请求方式
 在web.xml中注册HiddenHttpMethodFilter
**/

@Controller
public class RestFulController {

    /**
     * 使用RESTFul模拟用户资源的增删改查
     * /user    GET     查询所有用户信息
     * /user/1    GET     根据用户id查询用户信息
     * /user    POST     添加用户信息
     * /user/1    DELETE     删除用户信息
     * /user    PUT     修改用户信息
     */

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String testGetAllUser() {
        System.out.println("查询所有用户");
        return "success";
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public String testGetUserById(@PathVariable("id") Integer id) {
        System.out.println("查询用户Id为：" + id);
        return "success";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String testSaveUser(String username,String password) {
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }


    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public String testUpdateUser(@PathVariable("id") Integer id) {
        System.out.println("更新的用户Id为：" + id);
        return "success";
    }

}
