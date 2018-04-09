package com.junli.examples.mediator;

/**
 * 同事类A 设置同事类A的值影响B的值
 * 通过中介者来改变B的值
 *
 * @author lijun
 * @since 2018-04-09 9:42
 */
public class ConcreteColleagueA extends AbstractColleague {

    public ConcreteColleagueA(Mediator mediator) {
        super(mediator);
    }
    /**
     * 设置number的值
     *
     * @param number   值
     * @param mediator 中介者
     */
    @Override
    public void setNumber(int number, Mediator mediator) {
        this.number = number;
        mediator.affectB();
    }
}
