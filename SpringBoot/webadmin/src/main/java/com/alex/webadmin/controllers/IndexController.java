package com.alex.webadmin.controllers;

import javax.servlet.http.HttpSession;

import com.alex.webadmin.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
  
  /** 
   * 来登录页 
  */
  @GetMapping(value = {"/", "/login"})
  public String loginPage(){
    return "login";
  }

  @PostMapping("/login")
  public String main(User user, HttpSession session, Model model){
    
    if(!ObjectUtils.isEmpty(user.getUsername()) && !ObjectUtils.isEmpty(user.getPassword())){
      session.setAttribute("loginUser", user);
      //登入成功，重定向到main.html 重定向防止重复提交
      return "redirect:/main.html";
    }
    else{
      model.addAttribute("msg", "账号密码错误");
      return "login";
    }

  }

  @GetMapping("/main.html")
  public String mainPage(HttpSession session, Model model){
    return "main";
  }
}
