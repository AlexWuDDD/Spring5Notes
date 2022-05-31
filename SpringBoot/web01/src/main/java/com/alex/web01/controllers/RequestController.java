package com.alex.web01.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RequestController {
  
  @GetMapping("/goto")
  public String gotoPage(HttpServletRequest request){
    request.setAttribute("msg", "成功了...");
    request.setAttribute("code", 200);
    return "forward:/success";
  }

  @ResponseBody
  @GetMapping("/success")
  public Map<String, Object> success(
    @RequestAttribute("msg") String msg,
    @RequestAttribute("code") Integer code,
    HttpServletRequest request
  ){
    Object msg1 = request.getAttribute("msg");
    Object code1 = request.getAttribute("code");
    Map<String, Object> map = new HashMap<>();
    map.put("msg", msg);
    map.put("code", code);
    map.put("msg1", msg1);
    map.put("code1", code1);
    
    return map;
  }

  @GetMapping("/params")
  public String testParam(Map<String, Object> map,
                          Model model,
                          HttpServletRequest request,
                          HttpServletResponse response) {
  
    map.put("hello", "wordld666");
    model.addAttribute("world", "hello6666");
    request.setAttribute("message", "helloworld");

    Cookie cookie = new Cookie("c1", "v1");
    cookie.setDomain("localhost");

    response.addCookie(cookie);
    return "forward:/success1";
  }

  @ResponseBody
  @GetMapping("/success1")
  public Map<String, Object> success1(
    @RequestAttribute("hello") String hello,
    @RequestAttribute("world") String world,
    // @CookieValue("c1") String c1,
    HttpServletRequest request
  ){
    Object message = request.getAttribute("message");
    Map<String, Object> map = new HashMap<>();
    map.put("hello", hello);
    map.put("world", world);
    map.put("message", message);
    // map.put("c1", c1);
    
    return map;
  }

}
