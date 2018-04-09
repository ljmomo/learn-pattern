package com.junli.structure;

/**
 * 同事类的抽象父类
 * @author lijun
 * @since 2018-04-08 17:36
 */
public abstract class Colleague {

    /**
     * 持有中介者对象
     */
    private Mediator mediator;

    /**
     * 构造方法
     * @param mediator 中介者对象
     */
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 获取中介者
     * @return 中介者
     */
    public Mediator getMediator() {
        return mediator;
    }
}
