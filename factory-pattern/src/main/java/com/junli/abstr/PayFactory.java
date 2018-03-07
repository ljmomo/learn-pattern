package com.junli.abstr;

import com.junli.AliPay;
import com.junli.Pay;
import com.junli.UnionPay;
import com.junli.WxPay;

/**
 * @author lijun
 * @since 2018-03-05 9:23
 */
public class PayFactory extends AbstractFactory {
    /**
     * 获取阿里支付
     *
     * @return pay
     */
    @Override
    public Pay getAliPay() {
        return new AliPay();
    }

    /**
     * 获取微信Pay
     *
     * @return 微信
     */
    @Override
    public Pay getWxPay() {
        return new WxPay();
    }

    /**
     * 获取银联支付Pay
     *
     * @return 银联
     */
    @Override
    public Pay getUnitionPay() {
        return new UnionPay();
    }
}
