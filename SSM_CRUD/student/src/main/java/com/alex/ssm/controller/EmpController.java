package com.alex.ssm.controller;

import java.util.List;

import com.alex.ssm.bean.Emp;
import com.alex.ssm.bean.Msg;
import com.alex.ssm.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {

  @Autowired
  EmpService empService;

  /** 
   * 校验用户名是否可用
   */
  @RequestMapping(value="/checkempname", method = RequestMethod.GET)
  @ResponseBody
  public Msg checkEmpName(@RequestParam(value="empname")String empName){
    return empService.checkEmpName(empName)? Msg.success():Msg.fail();
  }

  /**
   * 添加员工
   */
  @RequestMapping(value="/emp", method = RequestMethod.POST)
  @ResponseBody
  public Msg addEmp(@RequestBody Emp emp){
    empService.addEmp(emp);
    return Msg.success();
  }
  /**
   * 查询员工数据（分页查询）
   */
  @RequestMapping("/emps")
  public String getEmps(@RequestParam(value="pn", defaultValue ="1")Integer pn, Model model) {
    //这不是一个分页查询
    //引入PageHelper分页插件
    //在查询之前只需要调用，传入页码，以及每页的大小
    PageHelper.startPage(pn, 5);
    List<Emp> emps = empService.getAll();
    //使用PageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
    //封装了详情的分页信息，包括由我们查询出来的数据, 传入连续显示的页数
    PageInfo<Emp> page = new PageInfo<>(emps, 5);//在页面需要连续显示的页码
    model.addAttribute("pageInfo", page);

    return "list";
  }

  /**
   * 导入jackson包
   * @param pn
   * @return
   */
  @RequestMapping("/empswithjson")
  @ResponseBody
  public PageInfo<Emp> getEmpsWithJson(@RequestParam(value="pn", defaultValue ="1")Integer pn){

    PageHelper.startPage(pn, 5);
    List<Emp> emps = empService.getAll();
    PageInfo<Emp> page = new PageInfo<>(emps, 5);
    return page;
  }

    /**
   * 导入jackson包
   * @param pn
   * @return
   */
  @RequestMapping("/empswithmsg")
  @ResponseBody
  public Msg getEmpsWithMsg(@RequestParam(value="pn", defaultValue ="1")Integer pn){

    PageHelper.startPage(pn, 5);
    List<Emp> emps = empService.getAll();
    PageInfo<Emp> page = new PageInfo<>(emps, 5);
    return Msg.success().add("pageInfo", page);
  }
}
