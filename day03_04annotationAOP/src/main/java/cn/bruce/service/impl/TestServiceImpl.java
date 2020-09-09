package cn.bruce.service.impl;

import cn.bruce.domain.Account;
import cn.bruce.service.TestService;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService {

    @Override
    public void testOfVoid() {
        System.out.println("testOfVoid is running......");
    }

    @Override
    public void testOfInt(int i) {
        System.out.println("testOfInt is running......number is" + i);
    }

    @Override
    public void testOfInteger(Integer i) {
//        i = 1/0;
        System.out.println("testOfInteger is running......number is" + i);

    }

    @Override
    public void testOfAccount(Account account) {
        int i = 1/0;
        System.out.println("testOfInt is running......number is" + account);

    }
}

