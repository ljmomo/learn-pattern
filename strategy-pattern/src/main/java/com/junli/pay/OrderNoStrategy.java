package com.junli.pay;

/**
 * OrderNoStrategy
 *
 * @author lijun
 * @since 2018-03-16 14:24
 */
public class OrderNoStrategy {

    /**
     * 阿里支付
     */
    private static final String ALI_PAY = "1";

    private static final String WX_PAY = "1";

    /**
     * 支付
     *
     * @param userId    用户ID
     * @param amount    支付金额
     * @param orderType 支付类型
     * @return
     */
    PayState pay(String userId, double amount, String orderType) {
        Payment payment = null;
        if (ALI_PAY.equals(orderType)) {
            payment = new AliPay();
        } else if (WX_PAY.equals(orderType)) {
            payment = new WechatPay();
        } else {
            payment = new AliPay();
        }
        return payment.pay(userId, amount);
    }
}
