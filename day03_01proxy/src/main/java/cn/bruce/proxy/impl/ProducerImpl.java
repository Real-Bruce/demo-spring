package cn.bruce.proxy.impl;

import cn.bruce.proxy.Producer;

public class ProducerImpl implements Producer {
    public void saleProduct(float money) {
        System.out.println("销售产品，拿到钱" + money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务得到钱" + money);
    }
}
