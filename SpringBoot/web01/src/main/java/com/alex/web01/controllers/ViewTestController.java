package com.alex.web01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
  
  @GetMapping("/alex")
  public String alex(Model model){
    model.addAttribute("msg", "你好 alex");
    model.addAttribute("link", "http://www.baidu.com");
    return "success";
  }
}
