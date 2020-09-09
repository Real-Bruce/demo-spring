package cn.bruce.dao;

import cn.bruce.domain.Account;

import java.util.List;

/**
 * @author Bruce
 * @create 2020-08-29 15:45
 */
public interface AccountDao {
    /**
     * 查询所有的账户
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据id查询单个用户
     * @param accountId
     * @return
     */
    Account getAccountById(Integer accountId);

    /**
     * 保存账户
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新账户信息
     * @param account
     * @return
     */
    void updateAccount(Account account);

    /**
     * 根据id删除账户
     * @param AccountId
     */
    void deleteAccount(Integer AccountId);

    /**
     * 根据名称获取账户信息
     * @param accountName
     */
    Account getAccountByName(String accountName);

}
