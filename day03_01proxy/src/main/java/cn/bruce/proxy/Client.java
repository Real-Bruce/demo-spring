package cn.bruce.proxy;

import cn.bruce.proxy.impl.ProducerImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        final ProducerImpl producer = new ProducerImpl();

        producer.saleProduct(1000f);// 销售产品，拿到钱1000.0
        System.out.println("对方法进行增强后。。。。。");
        Producer proxyProduct = (Producer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {

                    /**
                     * 执行被代理对象的任何接口方法都会经过该方法
                     * 方法的参数含义
                     * @param proxy  代理对象的引用
                     * @param method 当前执行方法
                     * @param args   当前执行方法所需的参数
                     * @return       和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 提供增强的代码
                        Object returnValue = null;
                        // 1.获取方法的执行参数
                        Float money = (Float) args[0];

                        // 2.判断当前方法是不是销售方法
                        if ("saleProduct".equals(method.getName())){
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        proxyProduct.saleProduct(1000f);// 销售产品，拿到钱800.0
    }
}
