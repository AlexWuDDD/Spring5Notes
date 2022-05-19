package com.alex.mybatis;

import java.util.List;

import com.alex.mybatis.mapper.SQLMapper;
import com.alex.mybatis.pojo.User;
import com.alex.mybatis.utils.SqlSessionUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SQLMapperTest {

  @Test
  public void testInsertUser(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
    User user = new User(null, "aaaaa", "1213", 19, "女", "sdwdwd@qq.com");
    mapper.insertUser(user);
    System.out.println(user);
  }

  @Test
  public void testGetUserByTableName(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
    List<User> users = mapper.getUserByTableName("t_user");
    users.forEach(System.out::println);
  }

  @Test
  public void testDeleteMore(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
    int result = mapper.deleteMore("1,2,3");
    System.out.println(result);
  }
  
  @Test
  public void testGetUserByName(){
    SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    SQLMapper mapper = sqlSession.getMapper(SQLMapper.class);
    List<User> users = mapper.getUserByName("admin");
    System.out.println(users);
  }
}
