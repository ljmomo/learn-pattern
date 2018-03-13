package com.junli.staticed;

/**
 * 经纪人
 * @author lijun
 * @since 2018-03-12 14:18
 */
public class Agent implements Star{


    private Star star;


    public Agent(Star star) {
        this.star = star;
    }

    /**
     * 面谈
     */
    @Override
    public void confer() {
        System.out.println("经纪人代表面谈！");
    }

    /**
     * 签合同
     */
    @Override
    public void signContract() {
        System.out.println("经纪人代表签合同！");
    }

    /**
     * 唱歌
     */
    @Override
    public void sing() {
        star.sing();
    }

    /**
     * 收尾款
     */
    @Override
    public void collectMoney() {
        System.out.println("经纪人代表收尾款！");
    }
}
