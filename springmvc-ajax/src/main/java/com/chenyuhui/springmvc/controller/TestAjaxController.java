package com.chenyuhui.springmvc.controller;

import com.chenyuhui.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 @RequestBody
 @RequestBody获取json格式的请求参数
 @RequestBody可以获取请求体信息，使用@RequestBody注解标识控制器方法的形参，当前请求的请求体就会为当前注解所标识的形参赋值
 在使用了axios发送ajax请求之后，浏览器发送到服务器的请求参数有两种格式：
 1、name=value&name=value...，此时的请求参数可以通过request.getParameter()获取，对应
 SpringMVC中，可以直接通过控制器方法的形参获取此类请求参数使用@RequestBody获取json格式的请求参数的条件：
 2、{key:value,key:value,...}，此时无法通过request.getParameter()获取，之前我们使用操作json的相关jar包gson或jackson
 处理此类请求参数，可以将其转换为指定的实体类对象或map集合。在SpringMVC中，直接使用@RequestBody注解标识控制器方法的形参
 即可将此类请求参数转换为java对象
 使用@RequestBody获取json格式的请求参数的条件：
 1、导入jackson的依赖
     <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.12.1</version>
     </dependency>
 2、SpringMVC的配置文件中设置开启mvc的注解驱动
    <mvc:annotation-driven />
 3、在控制器方法的形参位置，设置json格式的请求参数要转换成的java类型（实体类或map）的参
 数，并使用@RequestBody注解标识

 @ResponseBody
 @ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
 @ResponseBody响应浏览器json数据
 服务器处理ajax请求之后，大多数情况都需要向浏览器响应一个java对象，此时必须将java对象转换为
 json字符串才可以响应到浏览器，之前我们使用操作json数据的jar包gson或jackson将java对象转换为
 json字符串。在SpringMVC中，我们可以直接使用@ResponseBody注解实现此功能
 @ResponseBody响应浏览器json数据的条件：
 1、导入jackson的依赖
 2、SpringMVC的配置文件中设置开启mvc的注解驱动
 3、使用@ResponseBody注解标识控制器方法，在方法中，将需要转换为json字符串并响应到浏览器
 的java对象作为控制器方法的返回值，此时SpringMVC就可以将此对象直接转换为json字符串并响应到浏览器

 @RestController
 @RestController注解是springMVC提供的一个复合注解，标识在控制器的类上，就相当于为类添加了
 @Controller注解，并且为其中的每个方法添加了@ResponseBody注解
 **/


@Controller
public class TestAjaxController {


    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response,@RequestBody String requestBody) throws IOException {
        System.out.println("id=" + id);
        System.out.println(requestBody);
        response.getWriter().write("hello axios");
    }

    //@RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user,HttpServletResponse response) throws IOException {
        System.out.println(user);
        response.getWriter().write("hello RequestBody");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println(map);
        response.getWriter().write("hello RequestBody");
    }

    //@RequestMapping("/test/ResponseBody")
    /*public String testResponseBody() {
        //此时会跳转到逻辑视图success所对应的页面
        return "success";
    }*/

    @RequestMapping("/test/responseBody")
    @ResponseBody
    public String testResponseBody() {
        //此时会跳转到逻辑视图success所对应的页面
        return "success";
    }


    //响应浏览器实体类对象
    @RequestMapping("/test/responseBody/json/bean")
    @ResponseBody
    public User testResponseBodyToBeanJson() {
        User user = new User(1001,"admin1","123456",23,"男");
        return user;
    }


    //响应浏览器list集合
    @RequestMapping("/test/responseBody/json/list")
    @ResponseBody
    public List<User> testResponseBodyToListJson(){
        User user1 = new User(1001,"admin1","123456",23,"男");
        User user2 = new User(1002,"admin2","123456",23,"男");
        User user3 = new User(1003,"admin3","123456",23,"男");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }

    //响应浏览器map集合
    @RequestMapping("/test/responseBody/json/map")
    @ResponseBody
    public Map<String, Object> testResponseBodyToMapJson(){
        User user1 = new User(1001,"admin1","123456",23,"男");
        User user2 = new User(1002,"admin2","123456",23,"男");
        User user3 = new User(1003,"admin3","123456",23,"男");
        Map<String, Object> map = new HashMap<>();
        map.put("1001", user1);
        map.put("1002", user2);
        map.put("1003", user3);
        return map;
    }

}
