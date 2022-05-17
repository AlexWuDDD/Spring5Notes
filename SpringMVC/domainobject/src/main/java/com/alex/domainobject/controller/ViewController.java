package com.alex.domainobject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
  
  @RequestMapping("/testThymeleafView")
  public String testThymeleafView() {
    return "success";
  }

  //转发是浏览器只发了一次请求，请求的地址还是testForward
  @RequestMapping("/testForward")
  public String testForward(){
    return "forward:/testThymeleafView";
  }

  //转发是浏览器只发了两次请求，请求的地址是重定向的地址
  @RequestMapping("/testRedirect")
  public String testRedirect(){
    return "redirect:/testThymeleafView";
  }
}
