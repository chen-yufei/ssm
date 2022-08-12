package com.chenyuhui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/test/annotation")
    public String testAnnotation() {
        return "success";
    }

}
