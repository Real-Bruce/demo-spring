package cn.bruce.dao.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * @author Bruce
 * @create 2020-09-08 9:04
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    @Override
    public Account getAccountById(Integer accountId) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id = ?",
                new BeanPropertyRowMapper<Account>(Account.class),
                accountId);
        return accounts.isEmpty() ? null : accounts.get(0);
    }

    @Override
    public Account getAccountByName(String name) {
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where name = ?",
                new BeanPropertyRowMapper<Account>(Account.class), name);
        if (accounts.isEmpty()) {
            return null;
        }
        if (accounts.size() > 1) {
            throw new RuntimeException("结果集不唯一，可能存在问题");
        }
        return accounts.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ?, money = ? where id = ?", account.getName(),
                account.getMoney(), account.getId());
    }
}
