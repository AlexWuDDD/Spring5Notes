package alex.com.autowrap.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.autowrap.Emp;

public class test {
    

    @Test
    public void test1(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean9.xml");
        
        Emp emp = context.getBean("emp", Emp.class);
        emp.test();
    }
}
