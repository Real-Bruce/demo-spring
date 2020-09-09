package cn.bruce.ui;

import cn.bruce.factory.BeanFactory;
import cn.bruce.service.AccountService;
import cn.bruce.service.impl.AccountServiceImpl;

public class Client {

    public static void main(String[] args) {
//        AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        for (int i = 0; i < 5; i++) {
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
