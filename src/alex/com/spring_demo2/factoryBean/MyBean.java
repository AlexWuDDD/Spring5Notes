package alex.com.spring_demo2.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import alex.com.spring_demo2.collectionType.Course;

public class MyBean implements FactoryBean< Course>{

    //定义返回bean
    @Override
    public Course getObject() throws Exception {
        Course course = new Course();
        course.setCname("Java");
        return course;
    }

    @Override
    public Class getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }
    
}
