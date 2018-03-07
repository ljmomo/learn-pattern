package com.junli.abstr;

import com.junli.Pay;

/**
 * @author lijun
 * @since 2018-03-05 9:16
 */
public abstract class AbstractFactory{
    /**
     * 获取阿里支付
     * @return  pay
     */
    public  abstract Pay getAliPay();

    /**
     *获取微信Pay
     * @return 微信
     */
    public  abstract Pay getWxPay();

    /**
     * 获取银联支付Pay
     * @return 银联
     */
    public abstract Pay getUnitionPay();
}
