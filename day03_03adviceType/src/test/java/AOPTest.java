import cn.bruce.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        AccountService as = (AccountService) ac.getBean("accountService");

        as.saveAccount();
        System.out.println("-----------");
        as.updateAccount(12);
        System.out.println("-----------");
        as.deleteAccount();
    }
}
