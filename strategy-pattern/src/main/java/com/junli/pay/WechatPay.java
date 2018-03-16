package com.junli.pay;

/**
 * 微信支付
 * @author lijun
 * @since 2018-03-16 14:02
 */
public class WechatPay implements Payment {
    /**
     * 支付接口
     *
     * @param userId 用户ID
     * @param amount 支付金额
     * @return PayState 支付状态
     */
    @Override
    public PayState pay(String userId, double amount) {
        System.out.println("欢迎使用微信支付");
        System.out.println("直接从微信红包扣款");
        return new PayState(200,"支付成功",amount);
    }
}
