package com.alex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
  
  @RequestMapping(
    value = {"/", "/index"}
  )
  public String index(){
    return "index";
  }

  @RequestMapping("/param")
  public String param(){
    return "test_param";
  }
}
