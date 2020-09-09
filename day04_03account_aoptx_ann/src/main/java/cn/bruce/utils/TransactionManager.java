package cn.bruce.utils;

/**
 * @author Bruce
 * @create 2020-08-29 16:34
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 与事务控制相关的工具类，涉及事务的开启、回滚、关闭和连接的释放
 */
@Component("transactionManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* cn..impl.*.*(..))")
    private void pointcut(){}

    /**
     * 开启事务
     */
    public void beginTransaction() {
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启事务。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commit() {
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("提交事务。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollback() {
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("回滚事务。。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release() {
        try {
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
            System.out.println("释放连接。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Around("pointcut()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) {
        Object rtValue = null;

        try {
            // 1.获取参数
            Object[] args = joinPoint.getArgs();

            // 2.开启事务
            this.beginTransaction();

            // 3.执行操作
            rtValue = joinPoint.proceed(args);

            // 4.提交事务
            this.commit();

            // 返回结果
            return rtValue;
        } catch (Throwable e) {
            // 5.回滚事务
            this.rollback();
            throw new RuntimeException(e);
        } finally {
            // 6.释放资源
            this.release();
        }


    }
}
