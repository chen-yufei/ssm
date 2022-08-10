package com.chenyuhui.springmvc.controller;

import com.chenyuhui.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 SpringMVC获取请求参数
 一、通过ServletAPI获取：
 将HttpServletRequest作为控制器方法的形参，此时HttpServletRequest类型的参数表示封装了当前请求的请求报文的对象
 二、通过控制器方法的形参获取请求参数
 在控制器方法的形参位置，设置和请求参数同名的形参，当浏览器发送请求，匹配到请求映射时，
 在DispatcherServlet中就会将请求参数赋值给相应的形参
 三、@RequestParam
 @RequestParam是将请求参数和控制器方法的形参创建映射关系
 @RequestParam注解一共有三个属性：
 value：指定为形参赋值的请求参数的参数名
 required：设置是否必须传输此请求参数，默认值为true
 若设置为true时，则当前请求必须传输value所指定的请求参数，若没有传输该请求参数，且没有设置
 defaultValue属性，则页面报错400：Required String parameter 'xxx' is not present；若设置为
 false，则当前请求不是必须传输value所指定的请求参数，若没有传输，则注解所标识的形参的值为
 null
 defaultValue：不管required属性值为true或false，当value所指定的请求参数没有传输或传输的值
 为""时，则使用默认值为形参赋值
 四、@RequestHeader
 @RequestHeader是将请求头信息和控制器方法的形参创建映射关系
 @RequestHeader注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
 五、@CookieValue
 @CookieValue是将cookie数据和控制器方法的形参创建映射关系
 @CookieValue注解一共有三个属性：value、required、defaultValue，用法同@RequestParam
 六、通过POJO获取请求参数
 可以在控制器方法的形参位置设置一个实体类类型的形参，此时若浏览器传输的请求参数的参数名和实
 体类中的属性名一致，那么请求参数就会为此属性赋值
 **/


@Controller
public class TestParamController {

    @RequestMapping("/testParamByServletAPI")
    public String getParamByServletAPI(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }


    @RequestMapping(value = "/testParam",method = RequestMethod.POST)
    public String getParamByServletAPI(String username,String password) {
        System.out.println("通过控制器方法的形参获取请求参数");
        System.out.println("username=" + username + ",password=" + password);
        return "success";
    }

    @RequestMapping(value = "/testParamByRequestParam",method = RequestMethod.POST)
    public String getParamByRequestParam(
            @RequestParam(value = "username",required = false,defaultValue = "root") String username,
            @RequestParam(value = "password",required = true) String password,
            @RequestParam(value = "age",required = false,defaultValue = "15") int age) {
        System.out.println("通过@RequestParam获取请求参数");
        System.out.println("username=" + username + ",password=" + password + ",age=" + age);
        return "success";
    }

    @RequestMapping(value = "/testParamHeader")
    public String getParamHeader(
            @RequestHeader(value = "Referer",required = true,defaultValue = "localhost:8080") String referer,
            @RequestHeader(value = "Connection",required = false) String connection,
            @RequestHeader(value = "Host",required = true,defaultValue = "localhost:8080") String host) {
        System.out.println("通过@RequestHeader获取请求参数");
        System.out.println("referer=" + referer);
        System.out.println("connection=" + connection);
        System.out.println("host=" + host);
        return "success";
    }

    @RequestMapping(value = "/testParamCookieValue")
    public String getParamCookieValue(@CookieValue(value = "cname") String cname) {
        System.out.println("通过@CookieValue获取请求参数");
        System.out.println("cname=" + cname);
        return "success";
    }

    @RequestMapping(value = "/testParamByBean")
    public String getParamByBean(User user) {
        System.out.println("通过实体类对象获取请求参数");
        System.out.println(user);
        return "success";
    }








}
