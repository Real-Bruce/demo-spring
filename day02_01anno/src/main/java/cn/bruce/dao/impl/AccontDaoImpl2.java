package cn.bruce.dao.impl;

import cn.bruce.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccontDaoImpl2 implements AccountDao {

    public void saveAccount() {
        System.out.println("AccountDao保存了账户222222222222222222");
    }
}
