package alex.com.spring_demo2.collectionType;

//课程类
public class Course {

    @Override
    public String toString() {
        return "{" +
            " cname='" + cname + "'" +
            "}";
    }
    private String cname; //课程名称

    public void setCname(String cname){
        this.cname = cname;
    }
}
