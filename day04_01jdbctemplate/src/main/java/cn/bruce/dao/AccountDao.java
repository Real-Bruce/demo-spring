package cn.bruce.dao;

import cn.bruce.domain.Account;

/**
 * @author Bruce
 * @create 2020-08-29 9:52
 */
public interface AccountDao {

    Account getAccountById(Integer id);

    Account getAccountByName(String name);

    void updateAccount(Account account);
}
