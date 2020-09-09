package cn.bruce.cglib;

/**
 * 生产者
 */
public class Producer {

    public void saleProduct(float money) {
        System.out.println("售卖商品，得到钱" + money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，得到钱" + money);
    }

}
