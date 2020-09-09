package cn.bruce.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 用于数据库连接的工具类，从数据源中获取一个连接，并且实现数据绑定
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return 数据库连接
     */
    public Connection getThreadConnection(){

            try {
                // 1.先从ThreadLocation上获取
                Connection connection = threadLocal.get();
                // 2.判断当前线程上是否有连接
                if (connection == null) {
                    // 3. 从数据库源中获取一个链接，并存入到ThreadLocal中
                    connection = dataSource.getConnection();
                    threadLocal.set(connection);
                }
                // 4.返回当前线程上的连接
                return connection;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

    }

    /**
     * 将连接和线程解绑
     */
    public void removeConnection (){
        threadLocal.remove();
    }
}
