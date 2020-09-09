package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import cn.bruce.service.AccountService;
import cn.bruce.utils.TransactionManager;

import java.util.List;

public class AccountServiceImpl_OLD implements AccountService {

    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public List<Account> findAllAccount() {

        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3.提交事务
            transactionManager.commit();
            // 4.返回结果
            return accounts;
        } catch (Exception e) {
            // 5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6.释放连接
            transactionManager.release();
        }
    }

    @Override
    public Account getAccountById(Integer id) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            Account account = accountDao.getAccountById(id);
            // 3.提交事务
            transactionManager.commit();
            // 4.返回结果
            return account;
        } catch (Exception e) {
            // 5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6.释放连接
            transactionManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.saveAccount(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            transactionManager.beginTransaction();
            accountDao.updateAccount(account);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            transactionManager.beginTransaction();
            accountDao.deleteAccount(id);
            transactionManager.commit();
        } catch (Exception e) {
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            transactionManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            // 1.开启事务
            transactionManager.beginTransaction();
            // 2.执行操作
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);

            int i = 1/0;

            accountDao.updateAccount(source);
            accountDao.updateAccount(target);
            // 3.提交事务
            transactionManager.commit();
        } catch (Exception e) {
            // 4.操作失败则回滚事务
            transactionManager.rollback();
            throw new RuntimeException(e);
        } finally {
            // 5.释放连接
            transactionManager.release();
        }

    }
}
