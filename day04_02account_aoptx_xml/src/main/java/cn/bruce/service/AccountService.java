package cn.bruce.service;

import cn.bruce.domain.Account;

import java.util.List;

/**
 * @author Bruce
 * @create 2020-09-07 10:52
 */
public interface AccountService {

    /**
     * 查询所有
     * @return 所有的账户信息
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询账户
     * @param accountId
     * @return
     */
    Account getAccountById(Integer accountId);

    /**
     * 保存账户信息
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除账户信息
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 转账操作
     * @param sourceName 转出客户名称
     * @param targetName 目标客户名称
     * @param money 转出金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
