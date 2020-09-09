package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.dao.impl.AccountDaoImpl;
import cn.bruce.factory.BeanFactory;
import cn.bruce.service.AccountService;

public class AccountServiceImpl implements AccountService {

//    private AccountDao accountDao = new AccountDaoImpl();
    private AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        int i = 1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
