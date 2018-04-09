package com.junli.examples.mediator;

/**
 * 同事类B 设置同事类B的值影响B的值
 * 通过中介者来改变A的值
 *
 * @author lijun
 * @since 2018-04-09 9:42
 */
public class ConcreteColleagueB extends AbstractColleague {

    public ConcreteColleagueB(Mediator mediator) {
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
        mediator.affectA();
    }
}
