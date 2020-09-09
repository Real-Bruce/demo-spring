package cn.bruce.factory;

import cn.bruce.service.AccountService;
import cn.bruce.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    private AccountService accountService;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return (AccountService)Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if ("test".equals(method.getName())){
                            return method.invoke(accountService, args);
                        }

                        Object rtValue = null;
                        System.out.println("transfer..................");
                        try {
                            // 1.开启事务
                            transactionManager.beginTransaction();
                            // 2.执行操作
                            rtValue = method.invoke(accountService, args);
                            // 3.提交事务
                            transactionManager.commit();
                            // 4.返回结果
                            return rtValue;
                        } catch (Exception e) {
                            // 5.回滚事务
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            // 6.释放连接
                            transactionManager.release();
                        }
                    }
                });
    }
}
