package com.alex.mybatis.pojo;

import java.util.List;
import java.util.Objects;

public class Dept {
  
  private Integer did;
  private String deptName;

  private List<Emp> emps;

  public List<Emp> getEmps() {
    return this.emps;
  }

  public void setEmps(List<Emp> emps) {
    this.emps = emps;
  }


  public Dept() {
  }

  public Dept(Integer did, String deptName) {
    this.did = did;
    this.deptName = deptName;
  }

  public Integer getDid() {
    return this.did;
  }

  public void setDid(Integer did) {
    this.did = did;
  }

  public String getDeptName() {
    return this.deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  public Dept did(Integer did) {
    setDid(did);
    return this;
  }

  public Dept deptName(String deptName) {
    setDeptName(deptName);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Dept)) {
            return false;
        }
        Dept dept = (Dept) o;
        return Objects.equals(did, dept.did) && Objects.equals(deptName, dept.deptName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(did, deptName);
  }


  @Override
  public String toString() {
    return "{" +
      " did='" + getDid() + "'" +
      ", deptName='" + getDeptName() + "'" +
      ", emps='" + getEmps() + "'" +
      "}";
  }
  

}
