package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import cn.bruce.service.AccountService;

/**
 * @author Bruce
 * @create 2020-09-08 9:19
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account getAccountById(Integer accountId) {
        return accountDao.getAccountById(accountId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {

        System.out.println("开始进行转账操作。。。");

        Account source = accountDao.getAccountByName(sourceName);

        Account target = accountDao.getAccountByName(targetName);

        source.setMoney(source.getMoney() - money);

        target.setMoney(target.getMoney() + money);

        accountDao.updateAccount(source);

//        int i = 1/0;

        accountDao.updateAccount(target);

        System.out.println("转账完成。。。");
    }
}
