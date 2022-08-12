package com.chenyuhui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InterceptorController {


    @RequestMapping("/test/interceptor")
    public String testInterceptor() {
        return "success";
    }

}
