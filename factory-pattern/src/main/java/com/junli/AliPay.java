package com.junli;

/**
 * @author lijun
 * @since 2018-03-04 22:43
 */
public class AliPay  implements Pay {

    @Override
    public String getName() {
        return "支付宝支付";
    }
}
