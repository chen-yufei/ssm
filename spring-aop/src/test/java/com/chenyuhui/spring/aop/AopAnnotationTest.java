package com.chenyuhui.spring.aop;

import com.chenyuhui.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopAnnotationTest {

    @Test
    public void testAopByAnnotation() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-annotation.xml");
        Calculator calculator = ac.getBean(Calculator.class);
        calculator.add(1,2);
    }

    @Test
    public void testAopByAnnotationTwo() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-annotation.xml");
        Calculator calculator = ac.getBean(Calculator.class);
        calculator.div(1,0);
    }
}
