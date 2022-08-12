package com.chenyuhui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 SpringMVC提供了一个处理控制器方法执行过程中所出现的异常的接口：HandlerExceptionResolver
 HandlerExceptionResolver接口的实现类有：DefaultHandlerExceptionResolver和
 SimpleMappingExceptionResolver
 SpringMVC提供了自定义的异常处理器SimpleMappingExceptionResolver
**/


@Controller
public class ExceptionController {

    @RequestMapping("/test/handlerExceptionResolver")
    public String testHandlerExceptionResolver() {
        System.out.println(1/0);
        return "success";
    }

}
