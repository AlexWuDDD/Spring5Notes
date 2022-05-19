package com.alex.mybatis.pojo;

import java.util.Objects;

public class User {

  private Integer id;
  private String username;
  private String password;
  private Integer age;
  private String sex;
  private String email;


  public User() {
  }

  public User(Integer id, String username, String password, Integer age, String sex, String email) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.age = age;
    this.sex = sex;
    this.email = email;
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

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User id(Integer id) {
    setId(id);
    return this;
  }

  public User username(String username) {
    setUsername(username);
    return this;
  }

  public User password(String password) {
    setPassword(password);
    return this;
  }

  public User age(Integer age) {
    setAge(age);
    return this;
  }

  public User sex(String sex) {
    setSex(sex);
    return this;
  }

  public User email(String email) {
    setEmail(email);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(age, user.age) && Objects.equals(sex, user.sex) && Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, username, password, age, sex, email);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", username='" + getUsername() + "'" +
      ", password='" + getPassword() + "'" +
      ", age='" + getAge() + "'" +
      ", sex='" + getSex() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }

  
}
