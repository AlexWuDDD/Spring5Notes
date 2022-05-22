package com.alex.ssm.controller;

import java.util.List;

import com.alex.ssm.bean.Dept;
import com.alex.ssm.bean.Msg;
import com.alex.ssm.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DeptController {
  
  @Autowired
  DeptService deptService;

      /**
   * 导入jackson包
   * @param pn
   * @return
   */
  @RequestMapping("/depts")
  @ResponseBody
  public Msg getEmpsWithMsg(){
    List<Dept> depts = deptService.getAll();
    return Msg.success().add("depts", depts);
  }
}
