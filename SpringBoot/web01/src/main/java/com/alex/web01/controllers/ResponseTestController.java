package com.alex.web01.controllers;

import java.util.Date;

import com.alex.web01.bean.Pet;
import com.alex.web01.bean.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseTestController {
  
  /**
   * 1. 浏览器发送请求直接返回xml 【application/xml】 jacksonXmlConverter
   * 2. 如果是ajax请求，返回jason [application/json] jacksonJsonConverter
   * 3. 如果某个app发请求，返回自定义协议数据 [application/x-alex] xxxxConverter
   * 
   * 
   * 步骤：
   * 1. 添加自定义的MessageConverter进系统底层
   * 2. 系统底层就会统计出所有MessageConverter能操作哪些类型
   * 3. 客户端内容协商【alex-alex】
   *     属性值;属性值
   */
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
