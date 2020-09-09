package cn.bruce.factory;

import cn.bruce.service.AccountService;
import cn.bruce.service.impl.AccountServiceImpl;

public class InitFactory {
    public AccountService getAccountService (){
        return new AccountServiceImpl();
    }
}
