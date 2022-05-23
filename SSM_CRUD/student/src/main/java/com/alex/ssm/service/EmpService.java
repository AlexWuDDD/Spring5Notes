package com.alex.ssm.service;

import java.util.List;

import com.alex.ssm.bean.Emp;
import com.alex.ssm.bean.EmpExample;
import com.alex.ssm.bean.EmpExample.Criteria;
import com.alex.ssm.mapper.EmpMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmpService {

  @Autowired
  EmpMapper empMapper;


  /**
   * 查询所有员工
   * @return
   */
  public List<Emp> getAll() {
    return empMapper.selectByExampleWithDept(null);
  }

  /**
   * 添加员工
   */
  public void addEmp(Emp emp) {
    empMapper.insertSelective(emp);
  }

  /** 
   * 查找员工
  */
  public Emp findEmp(Integer id){
    return empMapper.selectByPrimaryKeyWithDept(id);
  }

  /** 
   * 员工更新
  */
  public void updateEmp(Emp emp){
    empMapper.updateByPrimaryKeySelective(emp);
  }

  /** 
   * 删除单个员工
  */
  public void deleteSingleEmp(Integer id){
    empMapper.deleteByPrimaryKey(id);
  }

  /**
   * 删除批量员工
   */
  public void deleteBatch(List<Integer> ids){
    EmpExample example = new EmpExample();
    Criteria criteria = example.createCriteria();
    criteria.andEmpIdIn(ids);
    empMapper.deleteByExample(example);
  }

  /**
   * 检验用户名是否可用
   * count == 0 可用， 反之，不可用
   */
  public boolean checkEmpName(String empName){
    EmpExample example = new EmpExample();
    Criteria criteria = example.createCriteria();
    criteria.andEmpNameEqualTo(empName);
    long count = empMapper.countByExample(example);
    return count == 0;
  }

}
