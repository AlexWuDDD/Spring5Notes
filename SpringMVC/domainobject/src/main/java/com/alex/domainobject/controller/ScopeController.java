package com.alex.domainobject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
  
  //使用servletAPI向request域对象共享数据
  @RequestMapping("/testRequestByServlet")
  public String testRequestByServlet(HttpServletRequest request) {
    request.setAttribute("testRequestScope", "hello, servletAPI");
    return "success";
  }
}
