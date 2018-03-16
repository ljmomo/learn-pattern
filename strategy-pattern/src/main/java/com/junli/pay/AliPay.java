package com.junli.pay;

/**
 * 支付宝支付
 * @author lijun
 * @since 2018-03-16 13:57
 */
public class AliPay implements Payment {
    /**
     * 支付接口
     *
     * @param userId 用户ID
     * @param amount 支付金额
     * @return PayState 支付状态
     */
    @Override
    public PayState pay(String userId, double amount) {
        System.out.println("欢迎使用支付宝");
        System.out.println("查询账户余额，开始扣款");
        return new PayState(200,"支付成功",amount);
    }
}
