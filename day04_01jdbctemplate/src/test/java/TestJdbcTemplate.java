import cn.bruce.dao.AccountDao;
import cn.bruce.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Bruce
 * @create 2020-08-29 11:11
 */
public class TestJdbcTemplate {

    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        accountDao.getAccountById(1);

        Account account = new Account();
        account.setName("123");
        account.setMoney(100F);

        accountDao.updateAccount(account);
    }
}
