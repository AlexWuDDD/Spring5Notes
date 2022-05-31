package com.alex.web01.controllers;

import java.util.Date;

import com.alex.web01.bean.Pet;
import com.alex.web01.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseTestController {
  
  @ResponseBody
  @GetMapping("/test/user")
  public User getUser(){
    User user = new User();
    user.setUserName("alex");
    user.setAge(31);
    user.setBirth(new Date());
    user.setPet(new Pet("阿狸", 3));

    return user;
  }
}
