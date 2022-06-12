package com.alex.webadmin.controllers;

import com.alex.webadmin.exception.UserTooManyException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestExceptionController {

  @GetMapping("/zero")
  public String zero(){
    int i = 1 / 0;
    return "main";
  }

  @GetMapping("/customer")
  public String customer(@RequestParam("name") String name){
    if("alex".equals(name)){
      throw new UserTooManyException("用户数量太多");
    }
    return "main";    
  }
}
