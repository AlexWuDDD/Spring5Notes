package com.alex.ssm.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

// import javax.validation.constraints.Email;


public class Emp {
    private Integer empId;

    @Pattern(regexp = "^([a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5}$)", message="用户名必须是6-16位英文字母、数字或下划线组成或者2-5位中文")
    private String empName;

    private String gender;

    @Email(message = "邮箱格式不正确")
    private String email;

    private Integer dId;

    //希望查询员工的同时部门信息也是查询好的
    private Dept  department;

    public Emp(){}

    public Emp(Integer empId, String empName, String gender, String email, Integer dId) {
        this.empId = empId;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }


    public Dept getDepartment() {
        return this.department;
    }

    public void setDepartment(Dept department) {
        this.department = department;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }


    @Override
    public String toString() {
        return "{" +
            " empId='" + getEmpId() + "'" +
            ", empName='" + getEmpName() + "'" +
            ", gender='" + getGender() + "'" +
            ", email='" + getEmail() + "'" +
            ", dId='" + getdId() + "'" +
            ", department='" + getDepartment() + "'" +
            "}";
    }

}