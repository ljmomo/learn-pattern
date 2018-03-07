package com.junli.func;

import com.junli.Pay;
import com.junli.UnionPay;

/**
 * @author lijun
 * @since 2018-03-04 23:32
 */
public class UnionPayFactory implements Factory{

    /**
     * @return Pay
     */
    @Override
    public Pay getPay() {
        return new UnionPay();
    }
}
