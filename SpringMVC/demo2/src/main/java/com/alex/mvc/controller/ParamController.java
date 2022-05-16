package com.alex.mvc.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.alex.mvc.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
  
  @RequestMapping("/testServletAPI")
  //形参位置的request表示当前请求
  public String testServletAPI(HttpServletRequest request){
    HttpSession session = request.getSession();
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    System.out.println("username: " + username);
    System.out.println("password: " + password);
    return "success";
  }

  @RequestMapping("/testParam")
  //多请求参数中出现多个同名的请求参数，可以在控制器方法的形参位置设置字符串类型或字符串数组来接收此请求参数
  //若使用字符串类型的形参，最终结果为每个请求参数的每一个值使用逗号拼接而成的字符串
  public String testParam(String username, String password, String[] hobby){
    System.out.println("username: " + username);
    System.out.println("password: " + password);
    System.out.println("hobby: " + Arrays.toString(hobby));
    return "success";
  }

  @RequestMapping("/testParam2")
  public String testParam2(
    @RequestParam(value="user_name", required=true, defaultValue = "root")String username,
    @RequestParam("pass_word")String password,
    @RequestParam("hobby")String[] hobby,
    @RequestHeader("Host")String host,
    @RequestHeader(value="sayHaHa", required=false, defaultValue = "sayHaha")String sayHaha,
    @CookieValue(value="JSESSIONID", required = false, defaultValue = "EMPTY")String jSessionId
    ){
      System.out.println("username: " + username);
      System.out.println("password: " + password);
      System.out.println("hobby: " + Arrays.toString(hobby));
      System.out.println("Host: " + host);
      System.out.println("sayHaHa: " + sayHaha);
      System.out.println("JSESSIONID: " + jSessionId);
      return "success";
  }

  @RequestMapping("/testBean")
  public String testBean(User user){
    System.out.println("user: " + user);
    return "success";
  }
}
