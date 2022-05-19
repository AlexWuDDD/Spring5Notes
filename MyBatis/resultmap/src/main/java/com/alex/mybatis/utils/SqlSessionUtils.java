package com.alex.mybatis.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionUtils {

  public static SqlSession getSqlSession() {
    SqlSession sqlSession = null;
    try{
      // 加载核心配置文件
      InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
      // 获取SqlSessionFactoryBuilder
      SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
      // 获取SqlSessionFactory
      SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
      // 获取sqlSession
      sqlSession = sqlSessionFactory.openSession(true);
    }
    catch(IOException e){
      e.printStackTrace();
    }
    return sqlSession;
  }
}
