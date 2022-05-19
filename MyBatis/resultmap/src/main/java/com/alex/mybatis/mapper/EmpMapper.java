package com.alex.mybatis.mapper;

import java.util.List;

import com.alex.mybatis.pojo.Emp;

import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
  
  //查询所有员工信息
  List<Emp> getAllEmp();

  //查询员工以及员工所对应的部门信息
  Emp getEmpAndDept(@Param("eid") Integer eid);

  //通过分布查询查询员工以及员工所对应的部门信息
  //分布查询的第一步
  Emp getEmpAndDeptByStepOne(@Param("eid") Integer eid);

  /**
   * 通过分布查询查询部分以及部门中所有员工的信息
   * 分布查询第二步
   */
  List<Emp> getDeptAndEmpsStepTwo(@Param("did") Integer did);
}
