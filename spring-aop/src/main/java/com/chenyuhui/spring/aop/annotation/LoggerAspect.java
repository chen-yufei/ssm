package com.chenyuhui.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 动态代理（InvocationHandler）：JDK原生的实现方式，需要被代理的目标类必须实现接口。因
 为这个技术要求代理对象和目标对象实现同样的接口（兄弟两个拜把子模式）。
 cglib：通过继承被代理的目标类（认干爹模式）实现代理，所以不需要目标类实现接口。
 AspectJ：本质上是静态代理，将代理逻辑“织入”被代理的目标类编译得到的字节码文件，所以最
 终效果是动态的。weaver就是织入器。Spring只是借用了AspectJ中的注解。
*/

/**
 前置通知：使用@Before注解标识，在被代理的目标方法前执行
 返回通知：使用@AfterReturning注解标识，在被代理的目标方法成功结束后执行（寿终正寝）
 异常通知：使用@AfterThrowing注解标识，在被代理的目标方法异常结束后执行（死于非命）
 后置通知：使用@After注解标识，在被代理的目标方法最终结束后执行（盖棺定论）
 环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕整个被代理的目标方法，包
 括上面四种通知对应的所有位置
**/


// @Aspect表示这个类是一个切面类
@Aspect
@Component
public class LoggerAspect {

    //@Pointcut("execution(public int com.chenyuhui.spring.aop.annotation.CalculatorImpl.add(int,int))")
    @Pointcut("execution(* com.chenyuhui.spring.aop.annotation.*.*(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger--->前置通知，方法名：" + methodName + ",方法参数：" + args);
    }

    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger--->后置通知，方法名：" + methodName + ",方法参数：" + args);
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterReturnMethod(JoinPoint joinPoint,Object result) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger--->后置返回通知，方法名：" + methodName + ",方法参数：" + args + ",结果：" + result);
    }

    @AfterThrowing(pointcut = "pointCut()",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger-->异常通知，方法名："+methodName+"，异常："+ex);
    }

    //环绕通知
    //@Around("execution(* com.chenyuhui.spring.aop.annotation.CalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知--->目标对象方法执行前");
            //目标对象（连接点）方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知-->目标对象方法返回值之后");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知-->目标对象方法出现异常时");
        } finally {
            System.out.println("环绕通知-->目标对象方法执行完毕");
        }
        return result;
    }



}
