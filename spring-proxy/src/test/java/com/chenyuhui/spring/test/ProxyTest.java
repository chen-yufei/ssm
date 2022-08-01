package com.chenyuhui.spring.test;


import com.chenyuhui.spring.proxy.Calculator;
import com.chenyuhui.spring.proxy.CalculatorImpl;
import com.chenyuhui.spring.proxy.CalculatorStaticProxy;
import com.chenyuhui.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void testStaticProxy() {
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1,2);
    }

    @Test
    public void testDynamicProxy() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1,3);
    }



}
