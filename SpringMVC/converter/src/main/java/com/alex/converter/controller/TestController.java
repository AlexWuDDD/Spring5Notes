package com.alex.converter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//拦截器

@Controller
public class TestController {

  @RequestMapping("/testInterceptor")
  public String testInterceptor(){
    System.out.println("testInterceptor");
    return "success";
  }


  @RequestMapping("/testExceptionHandler")
  public String testExceptionHandler(){
    System.out.println(1/0);
    return "success";
  }

  @RequestMapping("/testExceptionHandler2")
  public String testExceptionHandler2(){
    String str = null;
    str.replace(",", "");
    return "success";
  }

}
