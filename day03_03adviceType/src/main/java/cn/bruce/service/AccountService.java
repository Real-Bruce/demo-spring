package cn.bruce.service;

public interface AccountService {

    /**
     * 保存账户
     */
    void saveAccount();

    /**
     * 更新账户
     * @param i
     */
    void updateAccount(Integer i);

    /**
     * 删除账户
     * @return
     */
    int deleteAccount();
}
