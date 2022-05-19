package com.alex.mybatis.pojo;


public class Emp {
  
  private Integer eid;
  private String empName;
  private Integer age;
  private String sex;
  private String email;

  private Dept dept;

  public Emp() {
  }

  public Emp(Integer eid, String empName, Integer age, String sex, String email) {
    this.eid = eid;
    this.empName = empName;
    this.age = age;
    this.sex = sex;
    this.email = email;
  }


  public Integer getEid() {
    return this.eid;
  }

  public void setEid(Integer eid) {
    this.eid = eid;
  }

  public String getEmpName() {
    return this.empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
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

  public Dept getDept() {
    return this.dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }


  @Override
  public String toString() {
    return "{" +
      " eid='" + getEid() + "'" +
      ", empName='" + getEmpName() + "'" +
      ", age='" + getAge() + "'" +
      ", sex='" + getSex() + "'" +
      ", email='" + getEmail() + "'" +
      ", dept='" + getDept() + "'" +
      "}";
  }
  

}
