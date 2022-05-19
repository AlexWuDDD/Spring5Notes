package com.alex.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.alex.mybatis.mapper.UserMapper;
import com.alex.mybatis.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisTest {

  /**
   * SqlSession默认不自动提交事务，若需要自动提交事务
   * 可以使用SqlSessionFactory.openSession(true)
   *
   */

  @Test
  public void testMyBatis() throws IOException{
    //加载核心配置文件
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    //获取SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //获取SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    //获取sqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession();
    //获取mapper接口对象
    UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
    //测试功能
    int result = mapper.insertUser();
    //提交事务
    sqlSession.commit();
    System.out.println("result:"+result);
  }

  @Test
  public void testUpdate() throws IOException{
    //加载核心配置文件
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    //获取SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //获取SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    //获取sqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //获取mapper接口对象
    UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
    //测试功能
    mapper.updateUser();
  }

  @Test
  public void testDelete() throws IOException{
    //加载核心配置文件
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    //获取SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //获取SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    //获取sqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //获取mapper接口对象
    UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
    //测试功能
    mapper.deleteUser();
  }

  @Test
  public void testGetUserById() throws IOException{
    //加载核心配置文件
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    //获取SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //获取SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    //获取sqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //获取mapper接口对象
    UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
    //测试功能
    User user = mapper.getUserById();
    System.out.println(user);
  }

  @Test
  public void testGetAllUser() throws IOException{
    //加载核心配置文件
    InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
    //获取SqlSessionFactoryBuilder
    SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
    //获取SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    //获取sqlSession
    SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //获取mapper接口对象
    UserMapper mapper =  sqlSession.getMapper(UserMapper.class);
    //测试功能
    List<User> users = mapper.getAllUser();
    users.forEach(System.out::println);
  }
  
}
