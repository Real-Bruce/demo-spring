package cn.bruce.service.impl;

import cn.bruce.service.AccountService;

public class AccountServiceImpl implements AccountService {


    public AccountServiceImpl() {
        System.out.println("Service对象创建了！");
    }

    public void saveAccount() {
        System.out.println("Service创建的账户保存了");
    }

    public void init (){
        System.out.println("对象初始化。。。。");
    }

    public void destory (){
        System.out.println("对象销毁。。。。。");
    }
}
