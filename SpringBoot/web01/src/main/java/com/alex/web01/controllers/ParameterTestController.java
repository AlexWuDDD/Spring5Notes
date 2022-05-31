package com.alex.web01.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import com.alex.web01.bean.User;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ParameterTestController {

  @PostMapping("/saveuser")
  public Map<String, Object> saveUser(User user) {
    Map<String, Object> map = new HashMap<>();
    map.put("user", user);
    return map;
  }


  
  @GetMapping("/car/{id}/owner/{username}")
  public Map<String, Object> getCar(
      @PathVariable("id") Integer id ,
      @PathVariable("username") String username,
      @PathVariable Map<String, String> pv,
      @RequestHeader Map<String, String> rh,
      @RequestParam("age") Integer age,
      @RequestParam("inters") List<String> inters,
      @RequestParam Map<String, String> params,
      @CookieValue String _ga,
      @CookieValue("_ga") Cookie cookie
      ) {
    Map<String, Object> map = new HashMap<>();
    map.put("id", id);
    map.put("username", username);
    map.put("pv", pv);
    map.put("rh", rh);
    map.put("age", age);
    map.put("inters", inters);
    map.put("params", params);
    map.put("_ga", _ga);
    map.put("cookie", cookie);
    return map;
  }

  @PostMapping("/save")
  public Map<String, String> postMathod(@RequestBody String content) {
    Map<String, String> map = new HashMap<>();
    map.put("content", content);
    return map;
  }

  //1. "/cars/sell;low=34;brand=byd,audi,yd"
  //2. SpringBoot默认禁用了矩阵变量，需要配置
  //3. 手动开启，原理：对于路劲的处理。UrlPathHelper进行解析， 
  // removeSemicolonContent（移除分号内容）支持矩阵变量的
  @GetMapping("/cars/{path}")
  public Map<String, Object> carsSell(
    @MatrixVariable("low") Integer low, 
    @MatrixVariable("brand") List<String> brand,
    @PathVariable("path") String path
    ){
    Map<String, Object> map = new HashMap<>();
    map.put("low", low);
    map.put("brand", brand);
    map.put("path", path);
    return map; 
  }

  //"/boss/1;age=20/2;age=10"
  @GetMapping("/boss/{baossId}/{empId}")
  public Map<String, Object> boss(
    @MatrixVariable(value="age", pathVar="baossId") Integer bossAge,
    @MatrixVariable(value="age", pathVar="empId") Integer empAge
    
    ){
    Map<String, Object> map = new HashMap<>();
    map.put("bossAge", bossAge);
    map.put("empAge", empAge);
    return map;
  }


    
}
