package cn.bruce.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Bruce
 * @create 2020-08-29 16:05
 */
public class ConnectionUtils {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        try {
            // 1.从ThreadLocation上获取
            Connection conn = threadLocal.get();
            // 2.判断当前线程是否有连接
            if (conn == null) {
                // 3.从数据源中获取一个连接，并存入ThreadLocal中
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            // 4.返回当前线程上的连接
            return conn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将线程和连接解绑
     */
    public void removeConnection() {
        threadLocal.remove();
    }

}
