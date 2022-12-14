package com.chenyuhui.spring.test;

import com.chenyuhui.spring.pojo.HelloWorld;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class sayHelloTest {

    /**
     Spring Framework特性
     --非侵入式：使用 Spring Framework 开发应用程序时，Spring 对应用程序本身的结构影响非常
                小。对领域模型可以做到零污染；对功能性组件也只需要使用几个简单的注解进行标记，完全不会
                破坏原有结构，反而能将组件结构进一步简化。这就使得基于 Spring Framework 开发应用程序
                时结构清晰、简洁优雅。
     --控制反转：IOC——Inversion of Control，翻转资源获取方向。把自己创建资源、向环境索取资源
                变成环境将资源准备好，我们享受资源注入。
     --面向切面编程：AOP——Aspect Oriented Programming，在不修改源代码的基础上增强代码功能。
     --容器：Spring IOC 是一个容器，因为它包含并且管理组件对象的生命周期。组件享受到了容器化
     的管理，替程序员屏蔽了组件创建过程中的大量细节，极大的降低了使用门槛，大幅度提高了开发
     效率。
     --组件化：Spring 实现了使用简单的组件配置组合成一个复杂的应用。在 Spring 中可以使用 XML
     和 Java 注解组合这些对象。这使得我们可以基于一个个功能明确、边界清晰的组件有条不紊的搭
     建超大型复杂应用系统。
     --声明式：很多以前需要编写代码才能实现的功能，现在只需要声明需求即可由框架代为实现。
     --一站式：在 IOC 和 AOP 的基础上可以整合各种企业应用的开源框架和优秀的第三方类库。而且
              Spring 旗下的项目已经覆盖了广泛领域，很多方面的功能性需求可以在 Spring Framework 的基
              础上全部使用 Spring 来实现。
     **/

    @Test
    public void testSayHello() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld= (HelloWorld) ioc.getBean("helloWorld");
        helloWorld.sayHello();
    }

}
