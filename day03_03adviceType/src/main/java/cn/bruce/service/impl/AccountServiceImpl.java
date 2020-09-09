package cn.bruce.service.impl;

import cn.bruce.service.AccountService;

public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行保存账户操作");
    }

    public void updateAccount(Integer i) {
        System.out.println("执行更新账户操作" + i);
    }

    public int deleteAccount() {
        System.out.println("执行删除操作");
        int i = 1/0;
        return 0;
    }
}
