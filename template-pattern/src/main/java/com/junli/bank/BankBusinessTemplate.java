package com.junli.bank;

/**
 *银行办业务模板
 * @author lijun
 * @since 2018-03-19 15:17
 */
public abstract class BankBusinessTemplate {

    /**
     * 取号
     */
    private  void  takeNumber(){
        System.out.println("取到60号，等待办理业务");
    }

    /**
     * 办业务
     */
    public abstract void transactBusiness();

    /**
     * 服务评价打分
     */
    private void evaluate(){
        System.out.println("非常满意！");
    }

    /**
     * 业务处理
     */
    public void  progress(){
        takeNumber();
        transactBusiness();
        evaluate();
    }

}
