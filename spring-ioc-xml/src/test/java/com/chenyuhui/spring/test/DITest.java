package com.chenyuhui.spring.test;

import com.chenyuhui.spring.pojo.Clazz;
import com.chenyuhui.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITest {

    @Test
    public void testDIOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentOne",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDITwo() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentTwo",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIThree() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentThree",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIFour() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentFour",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIFive() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentFive",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDISix() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentSix",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDISeven() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentSeven",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIEight() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentEight",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDINine() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentNine",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIList() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz clazz = ac.getBean("clazzTwo",Clazz.class);
        System.out.println(clazz);
    }

    @Test
    public void testDITen() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentTen",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDIListTwo() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Clazz clazz = ac.getBean("clazzThree",Clazz.class);
        System.out.println(clazz);
    }

    @Test
    public void testDIEleven() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentEleven",Student.class);
        System.out.println(student);
    }

    @Test
    public void testDITwelve() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Student student = ac.getBean("studentTwelve",Student.class);
        System.out.println(student);
    }


}
