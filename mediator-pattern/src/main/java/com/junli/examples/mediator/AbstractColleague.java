package com.junli.examples.mediator;

/**
 * 同事抽象类
 * @author lijun
 * @since 2018-04-09 9:34
 */
public abstract class AbstractColleague {
    protected int number;
    private Mediator mediator;

    public AbstractColleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 设置number的值
     *
     * @param number   值
     * @param mediator 中介者
     */
    public abstract void setNumber(int number, Mediator mediator);

}
