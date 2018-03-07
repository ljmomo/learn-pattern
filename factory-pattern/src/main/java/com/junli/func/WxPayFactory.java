package com.junli.func;

import com.junli.Pay;
import com.junli.WxPay;

/**
 * @author lijun
 * @since 2018-03-04 23:30
 */
public class WxPayFactory implements Factory {
    /**
     * @return Pay
     */
    @Override
    public Pay getPay() {
        return new WxPay();
    }
}
