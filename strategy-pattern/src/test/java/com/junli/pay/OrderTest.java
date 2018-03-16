package com.junli.pay;

import org.junit.Test;

/**
 * @author lijun
 * @since 2018-03-16 14:08
 */
public class OrderTest {


    /**
     *
     * @throws Exception
     */
    @Test
    public void payNoStrategy() throws Exception {
        OrderNoStrategy order = new OrderNoStrategy();
        PayState payState = order.pay("lijun", 200,"1");
        System.out.println(payState);
    }

    /**
     * 测试支付
     * @throws Exception
     */
    @Test
    public void pay() throws Exception {
        Order order = new Order(new AliPay());
        PayState payState = order.pay("lijun", 200);
        System.out.println(payState);
    }

}