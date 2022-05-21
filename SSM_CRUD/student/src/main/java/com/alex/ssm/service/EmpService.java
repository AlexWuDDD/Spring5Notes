package com.alex.ssm.service;

import java.util.List;

import com.alex.ssm.bean.Emp;
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
  
}
