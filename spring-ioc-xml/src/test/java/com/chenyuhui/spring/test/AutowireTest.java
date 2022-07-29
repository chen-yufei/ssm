package com.chenyuhui.spring.test;

import com.chenyuhui.spring.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowireTest {

    @Test
    public void testAutowire() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ac.getBean(UserController.class);
        userController.saveUser();
    }

}
