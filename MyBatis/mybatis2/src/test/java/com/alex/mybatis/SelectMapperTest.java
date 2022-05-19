package com.alex.mybatis;

import java.util.List;
import java.util.Map;

import com.alex.mybatis.mapper.SelectMapper;
import com.alex.mybatis.pojo.User;
import com.alex.mybatis.utils.SqlSessionUtils;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class SelectMapperTest {

  /**
   * MyBatis的各种查询功能
   * 1. 若查询出的数据只有一条，可以通过实体类对象或者集合接收
   * 2. 若查询出的数据有多条，可以通过list接收,一定不能通过实体类对象接收，此时会报异常TooManyResultsException
   * 
   */

  @Test
  public void testGetAllUserToMap(){
    SqlSession sqlSession= SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    // List<Map<String, Object>> userMap = mapper.getAllUserToMap();
    Map<String, Object> userMap = mapper.getAllUserToMap();
    System.out.println(userMap);
  }

  @Test
  public void testGetUserByIdToMap(){
    SqlSession sqlSession= SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    Map<String, Object> userMap = mapper.getUserByIdToMap(5);
    System.out.println(userMap);
  }

  @Test
  public void testGetUserCount(){
    SqlSession sqlSession= SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    System.out.println(mapper.getUserCount());
  }


  @Test
  public void testGetAllUser(){
    SqlSession sqlSession= SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    List<User> users = mapper.getAllUser();
    users.forEach(System.out::println);
  }


  @Test
  public void testGetUserById(){
    SqlSession sqlSession= SqlSessionUtils.getSqlSession();
    SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
    User user = mapper.getUserById(5);
    System.out.println(user);
  }
}
