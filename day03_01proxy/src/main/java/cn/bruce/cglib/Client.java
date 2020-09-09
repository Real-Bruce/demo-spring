package cn.bruce.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {

    final Producer producer = new Producer();

    public static void main(String[] args) {

        final Producer producer = new Producer();

        producer.saleProduct(1000f);// 售卖商品，得到钱1000.0
        System.out.println("对方法进行增强后。。。。。");
        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行任何被处理对象的任何方法都会经过该方法
             * @param o           代理对象的引用
             * @param method      当前的执行方法
             * @param objects     当前执行方法所需的参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                // 提供增强的方法
                Object returnValue = null;

                // 1.获取当前方法的执行参数
                Float money = (Float) objects[0];
                // 2.判断当前的方法是不是销售动作
                if ("saleProduct".equals(method.getName())){
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(1000f);// 售卖商品，得到钱800.0
    }
}
