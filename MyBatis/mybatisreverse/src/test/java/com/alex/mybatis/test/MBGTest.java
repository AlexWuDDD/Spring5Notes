package com.alex.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alex.mybatis.bean.Emp;
import com.alex.mybatis.bean.EmpExample;
import com.alex.mybatis.mapper.EmpMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MBGTest {
  
  @Test
  public void testMBG(){
    try (
      InputStream is = Resources.getResourceAsStream("mybatis-config.xml")) {
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
      SqlSession sqlSession = sqlSessionFactory.openSession(true);
      EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
      //查询所有数据
      //List<Emp> emps= empMapper.selectByExample(null);
      //emps.forEach(System.out::println);
      // EmpExample example = new EmpExample();
      // example.createCriteria().andEmpNameEqualTo("张三").andAgeGreaterThan(20);
      // example.or().andDidIsNull();
      // List<Emp> emps = empMapper.selectByExample(example);
      // emps.forEach(System.out::println);
      // empMapper.updateByPrimaryKey(new Emp(1, "admin", 22, null, "456@qq.com", 3));
      empMapper.updateByPrimaryKeySelective(new Emp(2, "admin", 22, null, "456@qq.com", 3));

    } catch (IOException e) {
      
      e.printStackTrace();
    }
  }
}
