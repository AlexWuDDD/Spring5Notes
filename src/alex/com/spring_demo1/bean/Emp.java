package alex.com.spring_demo1.bean;

//员工类
public class Emp {
    private String ename;
    private String gender;

    //员工属于某一个部门，使用对象表示
    private Dept dept;

    public String getEname() {
        return this.ename;
    }

    public String getGender() {
        return this.gender;
    }

    public Dept getDept() {
        return this.dept;
    }

    public void setEname(String ename){
        this.ename = ename;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setDept(Dept dept){
        this.dept = dept;
    }

    public void add(){
        System.out.println(ename + "::" + gender + "::" + dept);
    }
}
