package com.chenyuhui.spring.aop;

import com.chenyuhui.spring.aop.xml.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopXmlTest {

    @Test
    public void testAopByXml() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-aop-xml.xml");
        Calculator calculator = ac.getBean(Calculator.class);
        calculator.add(1,2);
    }

}
