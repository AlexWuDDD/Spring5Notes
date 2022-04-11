package alex.com.spring_demo3.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.spring_demo3.config.MySpringConfig;
import alex.com.spring_demo3.service.UserService;

public class MyTest {
    
    @Test
    public void test1(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean11.xml");
        
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        ((ClassPathXmlApplicationContext)context).close();
    }

    @Test
    public void test2(){
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(MySpringConfig.class);
        
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();

        ((AnnotationConfigApplicationContext)context).close();
    }
}
