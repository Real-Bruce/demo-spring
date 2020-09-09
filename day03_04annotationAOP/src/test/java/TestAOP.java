import cn.bruce.config.SpringConfiguration;
import cn.bruce.domain.Account;
import cn.bruce.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAOP {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        TestService testService = (TestService) ac.getBean("testService");
        testService.testOfInt(133);
        System.out.println("-----------");
        testService.testOfInteger(112);
        System.out.println("-----------");
        testService.testOfVoid();
        System.out.println("-----------");

        Account account = (Account) ac.getBean("account");
        account.setName("Bruce");
        account.setAge(112);
        testService.testOfAccount(account);
    }
}
