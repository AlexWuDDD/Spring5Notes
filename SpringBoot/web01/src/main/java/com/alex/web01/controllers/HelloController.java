package com.alex.web01.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
public class HelloController {
  
  @RequestMapping("/1.png")
  public String hello(){
    return "hello";
  }

  @GetMapping(value="/user")
  public String getUser() {
      return "GET-张三";
  }
  
  @PostMapping(value="/user")
  public String saveUser() {
      return "POST-张三";
  }

  @PutMapping(value="/user")
  public String putUser() {
    return "PUT-张三";
  }

  @DeleteMapping(value="/user")
  public String deleteUser() {
    return "DELETE-张三";
  }

}
