package com.junli.structure;

/**
 * 具体的中介者
 * @author lijun
 * @since 2018-04-08 17:44
 */
public class ConcreteMediator implements Mediator {

    /**
     * 同事对象A
     */
    ConcreteColleagueA concreteColleagueA;
    /**
     * 同事对象B
     */
    ConcreteColleagueB concreteColleagueB;

    /**
     *设置同事对象A
     * @param concreteColleagueA
     */
    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    /**
     * 设置同事对象B
     * @param concreteColleagueB
     */
    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    /**
     * 同事对象在自身改变的情况的下通知中介者的方法
     * 让中介者去与其他同事交互
     *
     * @param colleague 同事对象
     */
    @Override
    public void charged(Colleague colleague) {
        //某个同事对象发生改变 需要和其他同事对象进行交互
        if (colleague == concreteColleagueA){
            concreteColleagueB.someOperation();
        }else{
            System.out.println("A 收到B的处理结果！");
        }
    }
}
