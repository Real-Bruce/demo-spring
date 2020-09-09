package cn.bruce.service.impl;

import cn.bruce.dao.AccountDao;
import cn.bruce.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.Date;

@Service("accountService1")
//@Scope("prototype")
public class AccountServiceImpl implements AccountService {

    //    @Autowired
//    @Qualifier("accountDao1")
    @Resource(name = "accountDao2")
    private AccountDao accountDao;

    @Value(value = "Bruce")
    private String name;

    @Value("30")
    private Integer age;

    @Autowired
    private Date birthday;

/*    @PostConstruct
    public void init() {
        System.out.println("初始化方法执行。。。。");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁方法执行。。。。");
    }*/

    public void saveAccount() {
        System.out.println("Service创建的账户保存了");
        accountDao.saveAccount();
    }

    public void show() {
        System.out.println(name + " " + age + " " + birthday);
    }
}
