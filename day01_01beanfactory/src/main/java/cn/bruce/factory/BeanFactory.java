package cn.bruce.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {

    // 定义properties类
    private static Properties props;

    // 定义一个Map，用于存放对象，可以称之为容器
    private static Map<String, Object> beans;
    // 使用静态代码块为Properties对象赋值
    static {
        try {
            // 实例化对象
            props = new Properties();
            // 获取properties文件对象流
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(inputStream);
            // 实例化容器
            beans = new HashMap<String, Object>();
            // 取出配置文件中的Key
            Enumeration keys = props.keys();
            // 遍历枚举
            while (keys.hasMoreElements()){
                // 取出每个key值
                String key = keys.nextElement().toString();
                // 根据key获取value值
                String beanPath = props.getProperty(key);
                // 反射创建对象
                Object value = Class.forName(beanPath).newInstance();
                // 将key和value放到容器中
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("初始化失败");
        }
    }

    /**
     * 根据bean的name获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        return beans.get(beanName);
    }

}
