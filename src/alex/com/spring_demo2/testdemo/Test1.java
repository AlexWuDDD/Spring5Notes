package alex.com.spring_demo2.testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.spring_demo2.collectionType.Book;
import alex.com.spring_demo2.collectionType.Course;
import alex.com.spring_demo2.collectionType.Stu;
import alex.com.spring_demo2.factoryBean.MyBean;

public class Test1 {
    
    @Test
    public void test1(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean5.xml");
        
            Stu stu = context.getBean("stu", Stu.class);
            stu.test();
    }

    @Test
    public void test2(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean6.xml");
        
            Book book1 = context.getBean("book", Book.class);
            Book book2 = context.getBean("book", Book.class);
            // book.test();
            System.out.println(book1);
            System.out.println(book2);
    }

    @Test
    public void test3(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean7.xml");
        
            Course course = context.getBean("mybean", Course.class);
            System.out.println(course);
    }
}
