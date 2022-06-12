package com.alex.webadmin.controllers;

import java.util.Arrays;
import java.util.List;

import com.alex.webadmin.bean.User;
import com.alex.webadmin.exception.UserTooManyException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TableController {
  
  @GetMapping("/basic_table")
  public String basic_table(){
    return "table/basic_table";
  }

  @GetMapping("/dynamic_table")
  public String dynamic_table(Model model){

    //表格内容的遍历
    List<User> users =  Arrays.asList(new User("zhangsan", "123456"), new User("lisi", "123456"), new User("wangwu", "123456"));

    model.addAttribute("users", users);

    if(users.size() > 1){
      throw new UserTooManyException();
    }

    return "table/dynamic_table";
  }

  @GetMapping("/responsive_table")
  public String responsive_table(){
    return "table/responsive_table";
  }

  @GetMapping("/editable_table")
  public String editable_table(){
    return "table/editable_table";
  }
}
