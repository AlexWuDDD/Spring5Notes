package alex.com.spring_demo1.testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.spring_demo1.bean.Emp;


public class TestBean2 {

    @Test
    public void testAdd2(){

        ApplicationContext context =
        new ClassPathXmlApplicationContext("bean4.xml");

        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }

    @Test
    public void testAdd(){

        ApplicationContext context =
        new ClassPathXmlApplicationContext("bean3.xml");

        Emp emp = context.getBean("emp", Emp.class);
        emp.add();
    }
}
