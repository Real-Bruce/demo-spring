package cn.bruce.dao.impl;

import cn.bruce.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccontDaoImpl implements AccountDao {

    public void saveAccount() {
        System.out.println("AccountDao保存了账户111111111111111111");
    }
}
