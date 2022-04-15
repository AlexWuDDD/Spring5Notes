package alex.com.jdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    
    //注入JdncTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addMoney() {
        String sql =  "update accounts set money = money + ? where user_name = ?";
        jdbcTemplate.update(sql, 100, "Mary");
        
    }

    @Override
    public void reduceMoney() {
        String sql =  "update accounts set money = money - ? where user_name = ?";
        jdbcTemplate.update(sql, 100, "Lucy");
    }
}
