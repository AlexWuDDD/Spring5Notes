package alex.com.aopannotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.aopannotation.User;

public class TestAop {
    
    @Test
    public void testAopAnno(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean12.xml");
        
        User user = context.getBean("user", User.class);
        user.add();

        ((ClassPathXmlApplicationContext)context).close();
    }

}
