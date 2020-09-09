package cn.bruce.factory;

import cn.bruce.service.AccountService;
import cn.bruce.service.impl.AccountServiceImpl;

public class StaticFactory {

    public static AccountService getAccountService (){
        return new AccountServiceImpl();
    }
}
