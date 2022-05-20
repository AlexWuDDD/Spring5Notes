package com.alex.mybatis;

import java.io.InputStream;

import com.alex.mybatis.mapper.CacheMapper;
import com.alex.mybatis.pojo.Emp;
import com.alex.mybatis.utils.SqlSessionUtils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CacheTest {
  
  @Test
  public void testOneCache(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    CacheMapper cacheMapper = sqlSession.getMapper(CacheMapper.class);
    Emp emp1 = cacheMapper.getEmpByEid(1);
    System.out.println(emp1);
    //cacheMapper.insertEmp(new Emp(null, "A", 20, "女", "12121@qq.com"));
    sqlSession.clearCache();//清空缓存
    Emp emp2 = cacheMapper.getEmpByEid(1);
    System.out.println(emp2);
    // SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
    // CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);
    // Emp emp2 = cacheMapper2.getEmpByEid(1);
    // System.out.println(emp2);
  }

  @Test
  public void testTwoCache(){
    try{
      InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
      SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
      SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

      CacheMapper cacheMapper1 = sqlSession1.getMapper(CacheMapper.class);
      CacheMapper cacheMapper2 = sqlSession2.getMapper(CacheMapper.class);

      Emp emp1 = cacheMapper1.getEmpByEid(1);
      System.out.println(emp1);
      sqlSession1.close();
      Emp emp2 = cacheMapper2.getEmpByEid(1);
      System.out.print(emp2);
      sqlSession2.close();
    }
    catch(Exception e){
      e.printStackTrace();
    }

  }
}
