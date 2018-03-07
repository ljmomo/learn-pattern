package com.junli;

import com.junli.abstr.PayFactory;
import com.junli.func.AliPayFactory;
import com.junli.func.Factory;
import com.junli.simple.SimpleFactory;
import org.junit.Test;

/**
 * @author lijun
 * @since 2018-03-04 22:50
 */
public class PayTest {
    /**
     * 简单工厂测试
     */
    @Test
    public void getSimplePay() {
        System.out.println(SimpleFactory.getPay("支付宝").getName());
    }

    /**
     * 工厂方法
     */
    @Test
    public void getFuncPay() {
        Factory factory = new AliPayFactory();
        System.out.println(factory.getPay().getName());
    }

    /**
     * 抽象工厂
     */
    @Test
    public void getAbstrPay(){
        PayFactory payFactory = new PayFactory();
        System.out.println(payFactory.getAliPay().getName());

    }

}