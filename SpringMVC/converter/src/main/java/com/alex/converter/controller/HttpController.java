package com.alex.converter.controller;


import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import com.alex.converter.bean.User;

import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HttpController {


  @RequestMapping("/testRequestBody")
  public String testRequestBody(@RequestBody String requestBody) {
    System.out.println(requestBody);
    return "success";
  }

  @RequestMapping("/testRequestEntity")
  public String testRequestEntity(RequestEntity<String> requestEntity) {
    //当前requestEntity表示的整个报文的请求信息
    System.out.println("请求头：" + requestEntity.getHeaders());
    System.out.println("请求体：" + requestEntity.getBody());
    return "success";
  }

  @RequestMapping("/testResponse")
  public void testResponse(HttpServletResponse response) throws IOException {
    response.getWriter().print("hello, response");
  }

  @RequestMapping("/testResponseBody")
  @ResponseBody
  public String testResponseBody(){
    //这个时候返回的是body
    return "success";
  }

  @RequestMapping("/testResponseUser")
  @ResponseBody
  public User testResponseUser(){
    //这个时候返回的是body
    return new User(1, "admin", "admin", 18, "male");
  }
  

  @RequestMapping("/testAxios")
  @ResponseBody
  public String testAxios(String username, String password){
    System.out.println(username + ", " + password);
    return "Hello, axios";
  }
}
