package com.alex.converter.bean;

public class User {
  private Integer id;
  private String username;
  private String password;
  private Integer age;
  private String sex;

  public User() {
  }

  public User(Integer id, String username, String password, Integer age, String sex) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.age = age;
    this.sex = sex;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

}
