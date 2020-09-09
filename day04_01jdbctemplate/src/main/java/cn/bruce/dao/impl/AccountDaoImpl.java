package cn.bruce.dao.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Bruce
 * @create 2020-08-29 9:56
 */
@Repository("AccountDao")
public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Account getAccountById(Integer id) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class), id);

        Account rtValue = accounts.isEmpty()?null:accounts.get(0);
        return rtValue;
    }

    @Override
    public Account getAccountByName(String name) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);

        if (accounts.isEmpty()){
            return null;
        }
        if (accounts.size() > 1){
            new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ?, money = ? where id = ?", account.getName(),
                account.getMoney(), account.getId());
    }
}
