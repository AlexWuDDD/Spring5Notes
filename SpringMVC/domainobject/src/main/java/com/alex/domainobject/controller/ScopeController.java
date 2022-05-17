package com.alex.domainobject.controller;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ScopeController {
  
  //使用servletAPI向request域对象共享数据
  @RequestMapping("/testRequestByServlet")
  public String testRequestByServlet(HttpServletRequest request) {
    request.setAttribute("testRequestScope", "hello, servletAPI");
    return "success";
  }

  //使用ModelAndView向request域对象共享数据
  @RequestMapping("/testModelAndView")
  public ModelAndView testModelAndView(){
    ModelAndView mav = new ModelAndView();
    //处理模型数据，即向请求域request共享数据
    mav.addObject("testRequestScope", "hello, ModelAndView");
    //设置视图名称
    mav.setViewName("success");
    return mav;
  }

  //使用Model向request域对象共享数据
  @RequestMapping("/testModel")
  public String testModel(Model model){
    model.addAttribute("testRequestScope", "hello, Model");
    System.out.println(model);
    System.out.println(model.getClass().getName());
    return "success";
  }

  //使用map向request域对象共享数据
  @RequestMapping("/testMap")
  public String testMap(Map<String, Object> map){
    map.put("testRequestScope", "hello, map");
    System.out.println(map);
    System.out.println(map.getClass().getName());
    return "success";
  }

  //使用ModelMap向request域对象共享数据
  @RequestMapping("/testModelMap")
  public String testModelMap(ModelMap modelMap){
    modelMap.addAttribute("testRequestScope", "hello, ModelMap");
    System.out.println(modelMap);
    System.out.println(modelMap.getClass().getName());
    return "success";
  }

  //向Session域共享数据
  @RequestMapping("/testSessionByServlet")
  public String testSessionByServlet(HttpSession session){
    session.setAttribute("testSessionScope", "hello, session");
    return "success";
  }

  //向application域共享对象
  @RequestMapping("/testApplicationByServlet")
  public String testApplication(HttpSession session){
    ServletContext application = session.getServletContext();
    application.setAttribute("testApplicationScope", "hello, application");
    return "success";
  }


}
