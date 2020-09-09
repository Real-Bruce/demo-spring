package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import cn.bruce.service.AccountService;

import java.util.List;

/**
 * @author Bruce
 * @create 2020-09-07 11:09
 */
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
    public Account getAccountById(Integer accountId) {
        return accountDao.getAccountById(accountId);
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
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        // 1.根据名称查询转出账户
        Account source = accountDao.getAccountByName(sourceName);

        // 2.根据名称查询转入帐户
        Account target = accountDao.getAccountByName(targetName);

        // 3.转出账户扣钱
        source.setMoney(source.getMoney() - money);

        // 4.转入账户加钱
        target.setMoney(target.getMoney() + money);

//        int i = 1/0;

        // 5.更新转出账户
        accountDao.updateAccount(source);

        // 6.更新转入账户
        accountDao.updateAccount(target);
    }
}
