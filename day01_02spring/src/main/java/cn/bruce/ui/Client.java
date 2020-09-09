package cn.bruce.ui;

import cn.bruce.dao.AccountDao;
import cn.bruce.service.AccountService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

    public static void main(String[] args) {
        // 1.获取核心容器对象
        // ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        // 通过绝对路径的方式获取核心容器对象
        ApplicationContext ac = new FileSystemXmlApplicationContext("E:\\workspace\\workspace_idea03\\demo-spring" +
                "\\day02_03spring\\src\\main\\resources\\beans.xml");
        //2.根据id获取Bean对象
        AccountService as = (AccountService) ac.getBean("accountService");
        AccountDao ad = ac.getBean("accountDao", AccountDao.class);

        System.out.println(as);
        System.out.println(ad);
        as.saveAccount();

        /*// 通过BeanFactory创建对象
        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService as = (AccountService) factory.getBean("accountService");
        System.out.println(as);*/

    }
}
