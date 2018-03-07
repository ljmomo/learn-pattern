package com.junli.simple;

import com.junli.AliPay;
import com.junli.Pay;
import com.junli.WxPay;

/**
 * @author lijun
 * @since 2018-03-04 22:53
 */
public class SimpleFactory {
    public static Pay getPay(String name) {
        Pay pay = null;
        if ("支付宝".equals(name)) {
            pay = new AliPay();
        } else if ("微信".equals(name)) {
            pay = new WxPay();
        } else if ("银联".equals(name)) {
            pay = new AliPay();
        }else{
            try {
                throw new Exception("没有找到");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return pay;
    }
}
