package com.chenyuhui.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 域对象共享数据
 一、使用ServletAPI向request域对象共享数据
 二、使用ModelAndView向request域对象共享数据
 三、使用Model向request域对象共享数据
 四、使用map向request域对象共享数据
 五、使用ModelMap向request域对象共享数据
 Model、ModelMap、Map的关系：
 Model、ModelMap、Map类型的参数其实本质上都是 BindingAwareModelMap 类型的
 public interface Model{}
 public class ModelMap extends LinkedHashMap<String, Object> {}
 public class ExtendedModelMap extends ModelMap implements Model {}
 public class BindingAwareModelMap extends ExtendedModelMap {}

 向session域共享数据

 向application域共享数据
 **/

@Controller
public class ScopeController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testScope", "hello,servletAPI");
        return "success";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("testScope", "hello,ModelAndView");
        //设置视图，实现页面跳转
        mav.setViewName("success");
        return mav;
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testScope", "hello,Model");
        return "success";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testScope", "hello,Map");
        return "success";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testScope", "hello,ModelMap");
        return "success";
    }


    //向session域共享数据
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("testSessionScope", "hello,session");
        return "success";
    }

    //向application域共享数据
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello,application");
        return "success";
    }

}
