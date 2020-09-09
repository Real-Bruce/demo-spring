package cn.bruce.dao.impl;

import cn.bruce.cn.bruce.domain.Account;
import cn.bruce.dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException(e);
        }
    }

    @Override
    public Account getAccountById(Integer id) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name, money) value(?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?, money = ? where id = ?",account.getName(),account.getMoney(),
                    account.getId());
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update("delete from account where id = ?", id);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }
}
