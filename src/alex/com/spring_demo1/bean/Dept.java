package alex.com.spring_demo1.bean;

//部门类
public class Dept{

    @Override
    public String toString() {
        return "{" +
            " dname='" + getDname() + "'" +
            "}";
    }

    private String getDname() {
        return this.dname;
    }

    private String dname;

    public void setDname(String dname){
        this.dname = dname;
    }


}