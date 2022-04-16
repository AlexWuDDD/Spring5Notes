package alex.com.jdbc.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import alex.com.jdbc.service.AccountService;

// @ExtendWith(SpringExtension.class)
// @ContextConfiguration("classpath:beanJDBC_2.xml")

@SpringJUnitConfig(locations = { "classpath:beanJDBC_2.xml" })
public class JTest5 {

    @Autowired
    private AccountService accountService;


    @Test
    public void test1() {
        accountService.transferMoney();
    }
    
}
