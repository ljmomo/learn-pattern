package com.junli.structure;

/**
 * @author lijun
 * @since 2018-04-09 9:11
 */
public class Client {
    public static void main(String[] args) {
        //创建终结者
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleagueA concreteColleagueA = new  ConcreteColleagueA(mediator);
        ConcreteColleagueB concreteColleagueB = new  ConcreteColleagueB(mediator);
        mediator.setConcreteColleagueA(concreteColleagueA);
        mediator.setConcreteColleagueB(concreteColleagueB);
        concreteColleagueA.someOperation();

    }
}
