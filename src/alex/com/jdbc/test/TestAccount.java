package alex.com.jdbc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
}
