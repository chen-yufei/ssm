package com.chenyuhui.spring.test;

import com.chenyuhui.spring.controller.UserController;
import com.chenyuhui.spring.dao.UserDao;
import com.chenyuhui.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocAnnotationTest {


    @Test
    public void testAnnotationIoc() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ac.getBean(UserController.class);
        UserService userService = ac.getBean(UserService.class);
        UserDao userDao = ac.getBean(UserDao.class);
        System.out.println(userController);
        System.out.println(userService);
        System.out.println(userDao);
    }

    @Test
    public void testAnnotationAutowire() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ac.getBean(UserController.class);
        userController.saveUser();
    }

}
