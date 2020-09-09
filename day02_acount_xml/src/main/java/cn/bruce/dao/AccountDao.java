package cn.bruce.dao;

import cn.bruce.cn.bruce.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAllAccount ();

    Account getAccountById (Integer id);

    void saveAccount (Account account);

    void updateAccount (Account account);

    void deleteAccount (Integer id);

}
