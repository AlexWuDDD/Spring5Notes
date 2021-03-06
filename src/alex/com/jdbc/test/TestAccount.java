package alex.com.jdbc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import alex.com.jdbc.config.TxConfig;
import alex.com.jdbc.service.AccountService;

public class TestAccount {

    PlatformTransactionManager platformTransactionManager;
    
    @Test
    public void test1(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("beanJDBC_2.xml");

            AccountService accountService = context.getBean("accountService", AccountService.class);

            accountService.transferMoney();

            ((ClassPathXmlApplicationContext)context).close();


    }

    @Test
    public void test2(){
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("beanJDBC_3.xml");

            AccountService accountService = context.getBean("accountService", AccountService.class);

            accountService.transferMoney();

            ((ClassPathXmlApplicationContext)context).close();


    }

    @Test
    public void test3(){
        ApplicationContext context = 
            new AnnotationConfigApplicationContext(TxConfig.class);
        
            AccountService accountService = context.getBean("accountService", AccountService.class);
            accountService.transferMoney();

            ((AnnotationConfigApplicationContext)context).close();
    }

    //函数式风格创建对象，交给spring进行管理
    @Test
    public void testGenericApplicationContext(){
        //1. 创建GenericApplicationContext
        GenericApplicationContext context = new GenericApplicationContext();
        //2. 调用context的方法对象注册
        context.refresh();
        // context.registerBean(User.class, ()->new User());
        context.registerBean("user1", User.class, ()->new User());
        //3. 获取在spring注册的对象
        // User user = (User)context.getBean("alex.com.jdbc.test.User");
        User user = (User)context.getBean("user1");
        System.out.println(user);
    }
}
  