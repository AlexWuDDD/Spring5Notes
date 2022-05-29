package com.alex.web01.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  
  @RequestMapping("/1.png")
  public String hello(){
    return "hello";
  }
}
