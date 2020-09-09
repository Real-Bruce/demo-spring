package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public AccountServiceImpl() {
        System.out.println("对象创建了！");
    }

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
