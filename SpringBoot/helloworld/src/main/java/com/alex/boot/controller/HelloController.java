package com.alex.boot.controller;

import com.alex.boot.bean.Car;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

// @ResponseBody
// @Controller
@Slf4j
@RestController
public class HelloController {
  
  @Autowired
  Car car;

  @RequestMapping("/car")
  public Car car(){
    log.info("/car 请求进来了....");
    return car;
  }

  @RequestMapping("/hello")
  public String handle01(){
    log.info("/hello 111 2222 333 请求进来了....");
    return "Hello, Spring Boot 2! " + "您好";
  }
}
