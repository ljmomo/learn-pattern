package com.junli.structure;

/**
 * @author lijun
 * @since 2018-03-16 11:18
 */
public  class Context {

    private  Strategy strategy;

    /**
     * 构造方法
     * @param strategy
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 上下文
     */
    public void contextInterface(){
        strategy.calcInfterface();
    }

}
