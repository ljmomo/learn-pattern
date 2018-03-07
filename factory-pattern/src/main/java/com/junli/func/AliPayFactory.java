package com.junli.func;

import com.junli.AliPay;
import com.junli.Pay;

/**
 * @author lijun
 * @since 2018-03-04 23:22
 */
public class AliPayFactory  implements Factory {
    /**
     *
     * @return 返回阿里支付
     */
    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
