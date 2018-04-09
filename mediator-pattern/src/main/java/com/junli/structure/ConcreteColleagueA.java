package com.junli.structure;

/**
 * 具体的同事对象A
 * @author lijun
 * @since 2018-04-08 17:45
 */
public class ConcreteColleagueA extends Colleague {
    /**
     * 构造方法
     *
     * @param mediator 中介者对象
     */
    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }

    /**
     * 做一些业务功能
     */
    public void  someOperation(){
        getMediator().charged(this);
    }
}
