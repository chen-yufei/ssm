package com.chenyuhui.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect()
@Component
@Order(1)
public class VerificationAspect {


    @Pointcut("execution(* com.chenyuhui.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("参数校验--->前置通知");
    }


}
