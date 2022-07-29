package com.chenyuhui.spring.test;

import com.chenyuhui.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-factory.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }

}
