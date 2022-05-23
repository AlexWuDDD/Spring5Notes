package com.alex.ssm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.alex.ssm.bean.Emp;
import com.alex.ssm.bean.Msg;
import com.alex.ssm.service.EmpService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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
   * 1.支持JSR303
   * 2.导入Hibernate-Validator
   */
  @RequestMapping(value="/checkempname", method = RequestMethod.GET)
  @ResponseBody
  public Msg checkEmpName(@RequestParam(value="empname")String empName) {
    return empService.checkEmpName(empName)? Msg.success():Msg.fail().add("detail", "用户名已存在");
  }

  /** 
   * 删除员工 单个批量二合一
   * 批量删除1-2-3
   * 单个删除：1
  */

  /** 
   * 删除单个员工
  */
  @RequestMapping(value="/emp/{ids}", method = RequestMethod.DELETE)
  @ResponseBody
  public Msg deleteSingleEmp(@PathVariable("ids") String ids){
    if(ids.contains("-")){
      List<Integer> del_ids = new ArrayList<>();
      String[] str_ids = ids.split("-");
      for(String str_id : str_ids){
        del_ids.add(Integer.parseInt(str_id));
      }
      empService.deleteBatch(del_ids);
    }
    else{
      Integer id = Integer.parseInt(ids);
      empService.deleteSingleEmp(id);
    }
    return Msg.success();
  }


  /**
   * 保存员工
   */
  @RequestMapping(value="/emp/{id}", method = RequestMethod.PUT)
  @ResponseBody
  public Msg updateEmp(@RequestBody Emp emp){
    empService.updateEmp(emp);
    return Msg.success();
  }

  /** 
   * 查询员工
   * */
  @RequestMapping(value="/emp/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Msg findEmp(@PathVariable("id") Integer id){
    Emp emp = empService.findEmp(id);
    return Msg.success().add("emp", emp);
  }

  /**
   * 添加员工
   */
  @RequestMapping(value="/emp", method = RequestMethod.POST)
  @ResponseBody
  public Msg addEmp(@RequestBody @Valid Emp emp, BindingResult result){
    System.out.println("/emp:" + emp);
    if(result.hasErrors()){
      List<FieldError> errors = result.getFieldErrors();
      Map<String, Object> map = new HashMap<>();
      for(FieldError filedError : errors){
        System.out.println("错误的字段名："+filedError.getField());
        System.out.println("错误信息：" + filedError.getDefaultMessage());
        map.put(filedError.getField(), filedError.getDefaultMessage());
      }
      return Msg.fail().add("errorFields", map);
    }
    else{
      empService.addEmp(emp);
      return Msg.success();
    }
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
