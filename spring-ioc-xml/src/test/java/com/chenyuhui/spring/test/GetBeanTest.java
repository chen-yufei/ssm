package com.chenyuhui.spring.test;

import com.chenyuhui.spring.pojo.HelloWorld;
import com.chenyuhui.spring.pojo.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetBeanTest {

    /**
     获取bean
     ①方式一：根据id获取
     由于 id 属性指定了 bean 的唯一标识，所以根据 bean 标签的 id 属性可以精确获取到一个组件对象。
     ②方式二：根据类型获取
     ③方式三：根据id和类型
     注意
     当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个
     当IOC容器中一共配置了两个：
     <bean id="helloworldOne" class="com.atguigu.spring.bean.HelloWorld"></bean>
     <bean id="helloworldTwo" class="com.atguigu.spring.bean.HelloWorld"></bean>
     根据类型获取时会抛出异常：NoUniqueBeanDefinitionException
     扩展：如果组件类实现了接口，根据接口类型可以获取bean吗？  >>>>可以，前提是bean唯一
          如果一个接口有多个实现类，这些实现类都配置了bean,根据接口类型可以获取bean吗？  >>>>不行，因为bean不唯一
     结论
     根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：『对象 instanceof 指定的类型』的返回结果，
     只要返回的是true就可以认定为和类型匹配，能够获取到。
     **/

    @Test
    public void testGetBeanOne() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld");
        helloWorld.sayHello();
    }

    @Test
    public void testGetBeanTwo() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        HelloWorld helloWorld =  ac.getBean(HelloWorld.class);
        helloWorld.sayHello();
    }

    @Test
    public void testGetBeanThree() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        HelloWorld helloWorld = (HelloWorld) ac.getBean("helloWorld",HelloWorld.class);
        helloWorld.sayHello();
    }

    //根据接口类型可以获取 bean：前提是bean唯一
    @Test
    public void testGetBeanFour() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        Person person  = ac.getBean(Person.class);
        System.out.println(person);
    }

}
