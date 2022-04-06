package alex.com.spring_demo1.testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import alex.com.spring_demo1.Book;
import alex.com.spring_demo1.Orders;
import alex.com.spring_demo1.User;

public class TestSpring5 {

    private ApplicationContext context =
    new ClassPathXmlApplicationContext("bean1.xml");

    @Test
    public void testOrders(){
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders);
        orders.testDemo();
    }

    @Test 
    public void testBook1(){
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
        book.testDemo();
    }

    @Test
    public void testAdd(){
        //1.加载Spring配置文件

    
        User user = context.getBean("user", User.class);

        System.out.println(user);
        user.add();

    }
}
