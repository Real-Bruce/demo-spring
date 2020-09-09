package cn.bruce.dao;

import cn.bruce.domain.Account;

/**
 * @author Bruce
 * @create 2020-09-08 8:43
 */
public interface AccountDao {

    Account getAccountById(Integer accountId);

    Account getAccountByName(String name);

    void updateAccount(Account account);
}
