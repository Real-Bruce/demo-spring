package cn.bruce.service.impl;

import cn.bruce.domain.Account;
import cn.bruce.service.TestService;

public class TestServiceImpl implements TestService {
    public void methodOfVoid() {

    }

    public int methodOfInt(int i) {
        return 0;
    }

    public Integer methodOfInteger() {
        System.out.println("methodOfInteger running ......");
        return null;
    }

    public String methodOfString(String str) {
        return null;
    }

    public Account methodOfAccount(Account account) {
        return null;
    }

}
