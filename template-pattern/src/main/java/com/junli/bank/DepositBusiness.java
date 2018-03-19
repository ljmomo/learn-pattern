package com.junli.bank;

/**
 * 存款业务
 * @author lijun
 * @since 2018-03-19 15:28
 */
public class DepositBusiness extends BankBusinessTemplate {
    /**
     * 办业务
     */
    @Override
    public void transactBusiness() {
        System.out.println("正在办理存款业务存入300元.");
    }
}
