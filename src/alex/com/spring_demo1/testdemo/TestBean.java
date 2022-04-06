package alex.com.spring_demo1.testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.spring_demo1.service.UserService;

public class TestBean {
    
    private ApplicationContext context =
        new ClassPathXmlApplicationContext("bean2.xml");

    @Test
    public void testAdd(){
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
