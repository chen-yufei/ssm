package com.chenyuhui.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;


@Component
public class VerificationAspect {

    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("参数校验--->前置通知");
    }

}
