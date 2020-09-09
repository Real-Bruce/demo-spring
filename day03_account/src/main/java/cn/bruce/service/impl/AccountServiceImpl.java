package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import cn.bruce.service.AccountService;

import java.util.List;

/**
 * 账户的业务层实现类
 * 事务控制应该实在业务层
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
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        // 2.1根据名称查询转出账户
        Account source = accountDao.findAccountByName(sourceName);
        // 2.2根据名称查询转入账户
        Account target = accountDao.findAccountByName(targetName);
        // 2.3转出账户扣钱
        source.setMoney(source.getMoney() - money);
        // 2.4转入账号加钱
        target.setMoney(target.getMoney() + money);
        // 2.5更新转出账户
        accountDao.updateAccount(source);

//        int i= 10/0;

        // 2.6更新转入账号
        accountDao.updateAccount(target);
        System.out.println("end..................");
    }
}
