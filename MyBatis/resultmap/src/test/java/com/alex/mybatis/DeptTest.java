package com.alex.mybatis;

import com.alex.mybatis.mapper.DeptMapper;
import com.alex.mybatis.pojo.Dept;
import com.alex.mybatis.utils.SqlSessionUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DeptTest {
  
  @Test
  public void testGetDeptAndEmps(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
    Dept dept = deptMapper.getDeptAndEmps(1);
    System.out.println(dept);
  }

  @Test
  public void testGetDeptAndEmpsStep(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
    Dept dept = deptMapper.getDeptAndEmpsStepOne(2);
    System.out.println(dept);
  }
}
