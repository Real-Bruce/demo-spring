package cn.breuce.test;

import cn.bruce.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Bruce
 * @create 2020-09-08 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("Bruce", "Taylor", 100f);
    }
}
