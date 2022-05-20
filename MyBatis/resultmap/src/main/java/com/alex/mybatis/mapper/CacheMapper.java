package com.alex.mybatis.mapper;

import com.alex.mybatis.pojo.Emp;

import org.apache.ibatis.annotations.Param;

public interface CacheMapper {
  Emp getEmpByEid(@Param("eid") Integer eid);

  void insertEmp(Emp emp);
}
