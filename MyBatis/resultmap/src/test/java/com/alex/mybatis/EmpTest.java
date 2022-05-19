package com.alex.mybatis;

import java.util.List;

import com.alex.mybatis.mapper.EmpMapper;
import com.alex.mybatis.pojo.Emp;
import com.alex.mybatis.utils.SqlSessionUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class EmpTest {

  
  @Test
  public void testGetAllEmp(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
    List<Emp> emps = empMapper.getAllEmp();
    emps.forEach(System.out::println);
  }

  @Test
  public void testGetEmpAndDept(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
    Emp emp =  empMapper.getEmpAndDept(1);
    System.out.println(emp);
  }

  @Test
  public void testGetEmpAndDeptByStep(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
    Emp emp =  empMapper.getEmpAndDeptByStepOne(2);
    System.out.println(emp.getEmpName());
    System.out.println("************************");
    System.out.println(emp.getDept().getDeptName());
  }
}
