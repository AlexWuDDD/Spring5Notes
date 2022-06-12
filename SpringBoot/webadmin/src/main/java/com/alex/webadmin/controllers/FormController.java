package com.alex.webadmin.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * 文件上传测试
 */

@Slf4j
@Controller
public class FormController {
  
  @GetMapping("/form_layouts")
  public String form_layouts() {
    return "form/form_layouts";
  }

  @PostMapping("/upload")
  public String upload (
    @RequestParam("email") String email, 
    @RequestParam("password") String password,
    @RequestPart("headImage") MultipartFile headImage,
    @RequestPart("photos") MultipartFile[] photos
    ) throws IOException{

    log.info("上传的信息，邮箱：{}, password: {}, headImage: {}, photos: {}", 
      email, password, headImage.getSize(), photos.length);

    if(!headImage.isEmpty()){
      //保存到文件服务器
      String filename = headImage.getOriginalFilename();
      headImage.transferTo(new File("/Users/alexwu/Desktop/" + filename));
    }

    if(photos.length > 0){
      for(MultipartFile photo : photos){
        if(!photo.isEmpty()){
          //保存到文件服务器
          String filename = photo.getOriginalFilename();
          photo.transferTo(new File("/Users/alexwu/Desktop/" + filename));
        }
      }
    }

    return "main";
  }
}
