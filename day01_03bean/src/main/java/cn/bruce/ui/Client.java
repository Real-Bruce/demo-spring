package cn.bruce.ui;

import cn.bruce.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        // 1.获取核心容器对象
        //ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        // 2.根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountService as1 = (AccountService) ac.getBean("accountService");

        System.out.println(as);
        System.out.println(as1);
        as.saveAccount();

        //手动关闭IoC容器
        ac.close();
    }
}
