import cn.bruce.service.AccountService;
import cn.bruce.service.TestService;
import cn.bruce.service.impl.TestServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        AccountService as = (AccountService) ac.getBean("accountService");

        TestService ts = (TestService) ac.getBean("testService");

        as.saveAccount();
        as.updateAccount(12);
        as.deleteAccount();
        System.out.println("-----------");
        ///----------测试切入点写法------
        ts.methodOfVoid();

        ts.methodOfInteger();
    }
}
