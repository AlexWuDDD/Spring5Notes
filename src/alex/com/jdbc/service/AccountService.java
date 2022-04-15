package alex.com.jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import alex.com.jdbc.dao.AccountDao;

@Service
@Transactional(propagation = Propagation.REQUIRED,
    isolation = Isolation.REPEATABLE_READ)
public class AccountService {

    @Autowired
    private AccountDao accountDao;

    //转账的方法
    public void transferMoney(){

    //     try{
    //         //第一步 开启事务

    //         //第二步 进行业务操作

            accountDao.reduceMoney();


            //模拟异常
            int i = 1/0;


            accountDao.addMoney();

    //         //第三步 没有发生异常，提交异常
    //     }
    //     catch(Exception e){
    //         //第四步 出现异常，事务回滚
    //     }
    }
}