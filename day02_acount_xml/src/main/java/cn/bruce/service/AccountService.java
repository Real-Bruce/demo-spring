package cn.bruce.service;

import cn.bruce.cn.bruce.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAllAccount ();

    Account getAccountById (Integer id);

    void saveAccount (Account account);

    void updateAccount (Account account);

    void deleteAccountById (Integer id);
}
