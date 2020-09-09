package cn.bruce.utils;

/**
 * @author Bruce
 * @create 2020-08-29 16:34
 */

import java.sql.SQLException;

/**
 * 与事务控制相关的工具类，涉及事务的开启、回滚、关闭和连接的释放
 */
public class TransactionManager {

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

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
            System.out.println("释放连接。。。。");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
