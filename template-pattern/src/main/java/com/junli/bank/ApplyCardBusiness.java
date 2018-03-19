package com.junli.bank;

/**
 * 办卡业务
 * @author lijun
 * @since 2018-03-19 15:35
 */
public class ApplyCardBusiness  extends BankBusinessTemplate {
    /**
     * 办业务
     */
    @Override
    public void transactBusiness() {
        System.out.println("正在办理办卡业务 你成功申请了一张卡卡号 8888888888888888");
    }
}
