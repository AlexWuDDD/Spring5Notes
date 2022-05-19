package com.alex.mybatis.mapper;

import java.util.List;

import com.alex.mybatis.pojo.User;

public interface UserMapper {

  /**
   * MyBatis面向接口编程的两个一致：
   * 1. 映射文件的namespace要和mapper接口的全类名保持一致
   * 2. 映射文件的id要和mapper接口的方法名保持一致
   * 
   * 
   * 表--实体类--mapper接口--映射文件
   */

  /**
   * 添加用户信息
   */
  int insertUser();

  /**
   * 修改用户信息
   */
  void updateUser();

  /**
   * 删除用户信息
   */
  void deleteUser();

  /**
   * 根据id查询用户信息
   */
  User getUserById();

  /**
   * 查询所有的用户信息
   */
  List<User> getAllUser();
}
