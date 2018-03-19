package com.junli.bank;

/**
 * 取款业务
 * @author lijun
 * @since 2018-03-19 15:25
 */
public class WithdrawalBusiness extends BankBusinessTemplate {
    /**
     * 办业务
     */
    @Override
    public void transactBusiness() {
        System.out.println("正在办理取款业务取出300元.");
    }
}
