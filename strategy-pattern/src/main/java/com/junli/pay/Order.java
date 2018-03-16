package com.junli.pay;

/**
 * 订单
 *
 * @author lijun
 * @since 2018-03-16 14:03
 */
public class Order {

    /**
     * payment 支付接口
     */
    private Payment payment;

    public Order(Payment payment) {
        this.payment = payment;
    }

    /**
     * 上下文支付 和具体的策略类交互
     *
     * @param userId
     * @param amount
     * @return
     */
    PayState pay(String userId, double amount) {
        return payment.pay(userId, amount);
    }
}
