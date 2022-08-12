package com.chenyuhui.springmvc.config;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice  //将当前类标识为异常处理的组件
public class HandlerExceptionResolver {


    //@ExceptionHandler用于设置所标识方法处理的异常
    //ex表示当前请求处理中出现的异常对象
    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(Exception ex, Model model){
        model.addAttribute("ex", ex);
        return "error";
    }

}
