package cn.bruce.service.impl;

import cn.bruce.cn.bruce.domain.Account;
import cn.bruce.dao.AccountDao;
import cn.bruce.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account getAccountById(Integer id) {
        return accountDao.getAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccountById(Integer id) {
        accountDao.deleteAccount(id);
    }
}
