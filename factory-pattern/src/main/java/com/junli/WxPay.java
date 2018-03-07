package com.junli;

/**
 * @author lijun
 * @since 2018-03-04 22:47
 */
public class WxPay  implements Pay {
    @Override
    public String getName() {
        return "微信支付";
    }
}
