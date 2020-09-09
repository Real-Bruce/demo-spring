package cn.bruce.ui;

import cn.bruce.dao.AccountDao;
import cn.bruce.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        // 1.获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        // 2.根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService2");
//        AccountService as1 = (AccountService) ac.getBean("accountServiceImpl");
//        AccountDao ad = ac.getBean("accountDao1", AccountDao.class);
//        AccountService as = ac.getBean("accountService", AccountService.class);

        System.out.println(as);
//        System.out.println(as1);
//        System.out.println(as == as1);
//        System.out.println(ad);
        as.show();
//        as.saveAccount();
//        ac.close();
    }
}
