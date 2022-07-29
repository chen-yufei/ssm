package com.chenyuhui.spring.test;

import com.chenyuhui.spring.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LifeCycleTest {

    /**
     具体的生命周期过程
     bean对象创建（调用无参构造器）
     给bean对象设置属性
     bean对象初始化之前操作（由bean的后置处理器负责）
     bean对象初始化（需在配置bean时指定初始化方法）
     bean对象初始化之后操作（由bean的后置处理器负责）
     bean对象就绪可以使用
     bean对象销毁（需在配置bean时指定销毁方法）
     IOC容器关闭
     **/

    @Test
    public void testLifeCycle() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-lifecycle.xml");
        User user = ac.getBean(User.class);
        ac.close();
    }

}
