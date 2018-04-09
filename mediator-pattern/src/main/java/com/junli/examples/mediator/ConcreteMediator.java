package com.junli.examples.mediator;

/**
 * 具体 的中介者
 *
 * @author lijun
 * @since 2018-04-09 9:37
 */
public class ConcreteMediator implements Mediator {

    /**
     * 中介者持有同事类A
     */
    ConcreteColleagueA  concreteColleagueA;

    /**
     * 中介者持有同类B
     */
    ConcreteColleagueB concreteColleagueB;


    public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA) {
        this.concreteColleagueA = concreteColleagueA;
    }

    public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB) {
        this.concreteColleagueB = concreteColleagueB;
    }

    /**
     * 影响A
     */
    @Override
    public void affectA() {
        concreteColleagueA.setNumber(concreteColleagueB.getNumber()/100);
    }

    /**
     *
     */
    @Override
    public void affectB() {
        concreteColleagueB.setNumber(concreteColleagueA.getNumber()*100);
    }
}
