package com.alex.ssm.bean;

public class Emp {
    private Integer empId;

    private String empName;

    private String gender;

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