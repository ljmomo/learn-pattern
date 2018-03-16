package com.junli.pay;

/**
 * 支付 的策略接口
 * @author lijun
 * @since 2018-03-16 13:48
 */
public interface Payment {
    /**
     * 支付接口
     * @param userId 用户ID
     * @param amount 支付金额
     * @return PayState 支付状态
     */
    PayState pay(String userId,double amount);
}
