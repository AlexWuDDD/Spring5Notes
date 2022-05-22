package com.alex.ssm.service;

import java.util.List;

import com.alex.ssm.bean.Dept;
import com.alex.ssm.mapper.DeptMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
  
  @Autowired
  DeptMapper deptMapper;

  /**
   * 查询所有部门
   */
  public List<Dept> getAll() {
    return deptMapper.selectByExample(null);
  }

}
