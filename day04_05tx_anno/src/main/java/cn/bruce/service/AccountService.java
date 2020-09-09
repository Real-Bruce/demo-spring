package cn.bruce.service;

import cn.bruce.domain.Account;

/**
 * @author Bruce
 * @create 2020-09-08 9:16
 */
public interface AccountService {

    Account getAccountById(Integer accountId);

    void transfer(String sourceName, String targetName, Float money);
}
