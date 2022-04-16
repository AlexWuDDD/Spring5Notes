package alex.com.jdbc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import alex.com.jdbc.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class) //单元测试框架
@ContextConfiguration("classpath:beanJDBC_2.xml") //加载配置文件
public class JTest4 {
    
    @Autowired
    private AccountService accountService;

    @Test
    public void test1(){
        accountService.transferMoney();
    }
}
