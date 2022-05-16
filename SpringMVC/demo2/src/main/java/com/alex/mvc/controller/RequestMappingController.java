package com.alex.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/hello")
public class RequestMappingController {
  
  @RequestMapping(
    value={"/testRequestMapping", "/test"},
    method={RequestMethod.GET, RequestMethod.POST}
  )
  public String success(){
    return "success";
  }

  //查询
  @GetMapping("/testGetMapping")
  public String testGetMapping(){
    return "success";
  }

  //新增
  @PostMapping("/testPostMapping")
  public String testPostMapping(){
    return "success";
  }

  //修改
  @PutMapping("/tesPutMapping")
  public String testPutMapping(){
    return "success";
  }

  //删除
  @DeleteMapping("/testDeleteMapping")
  public String testDeleteMapping(){
    return "success";
  }

  @RequestMapping(
    value="/testParamsAndHeaders",
    params = {"username", "password=123"},
    headers = {"Host=localhost:8080"}
  )
  public String testParamsAndHeaders(){
    return "success";
  }

  @RequestMapping("/a?a/testAnt")
  public String testAnt(){
    return "success";
  }

  @RequestMapping("/a*a/testAnt")
  public String testAnt1(){
    return "success";
  }

  @RequestMapping("/**/testAnt")
  public String testAnt2(){
    return "success";
  }
}
