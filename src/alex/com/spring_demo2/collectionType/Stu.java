package alex.com.spring_demo2.collectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Stu {
    //1.数组类型的属性
    private String[] courses;

    //2.list集合类型属性
    private List<String> list;
    
    //3. map集合类型属性
    private Map<String, String> map;

    //4. set集合类型属性
    private Set<String> sets;

    //5. 学生所学多门课程
    private List<Course> coursesList;

    public void setCoursesList(List< Course> coursesList) {
        this.coursesList = coursesList;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String,String> map) {
        this.map = map;
    }

    public void test(){
        System.out.println(Arrays.toString(courses));
        System.out.println(list);
        System.out.println(map);
        System.out.println(sets);
        System.out.println(coursesList);
    }

}

