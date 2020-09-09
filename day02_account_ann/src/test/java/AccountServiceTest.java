import cn.bruce.domain.Account;
import cn.bruce.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private AccountService accountService = null;

    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
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
        account.setMoney(120f);
        accountService.saveAccount(account);
    }

    @Test
    public void testUpdateAccount(){
        Account account = new Account();
        account.setId(4);
        account.setName("Taylor");
        account.setMoney(10000f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount(){
        accountService.deleteAccount(1);
    }


}
