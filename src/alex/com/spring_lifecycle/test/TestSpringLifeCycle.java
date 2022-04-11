package alex.com.spring_lifecycle.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.spring_lifecycle.bean.Orders;

public class TestSpringLifeCycle {

    @Test
    public void test1(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("bean8.xml");
        
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("第四步 获取创建bean实例对象");
        System.out.println(orders);

        //手动让bean实例销毁
        ((ClassPathXmlApplicationContext)context).close();
    }
    
}
