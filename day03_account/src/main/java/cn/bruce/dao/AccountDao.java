package cn.bruce.dao;

import cn.bruce.domain.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAllAccount ();

    Account getAccountById (Integer id);

    void saveAccount (Account account);

    void updateAccount (Account account);

    String deleteAccount (Integer id);

    Account findAccountByName (String accountName);
}
