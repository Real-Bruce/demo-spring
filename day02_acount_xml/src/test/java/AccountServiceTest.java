import cn.bruce.cn.bruce.domain.Account;
import cn.bruce.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService accountService = null;

    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void testGetAccountById(){
        Account account = accountService.getAccountById(3);
        System.out.println(account);
    }

    @Test
    public void testSaveAccount(){
        Account account = new Account();
        account.setName("Bruce");
        account.setMoney(120.2);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount(){
        Account account = new Account();
        account.setId(5);
        account.setName("Taylor");
        account.setMoney(10000.1);
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){
        accountService.deleteAccountById(2);
    }

}
