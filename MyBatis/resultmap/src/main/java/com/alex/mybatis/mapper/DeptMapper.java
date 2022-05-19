package com.alex.mybatis.mapper;

import com.alex.mybatis.pojo.Dept;

import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
  
  //通过分布查询查询员工以及员工所对应的部门信息
  //分布查询的第二步
  Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

  //获取部门以及部门中所有的员工信息
  Dept getDeptAndEmps(@Param("did") Integer did);

  /**
   * 通过分布查询查询部分以及部门中所有员工的信息
   * 分布查询第一步
   */

  Dept getDeptAndEmpsStepOne(@Param("did") Integer did);
}
