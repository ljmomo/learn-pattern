package com.junli.examples.mediator;

/**
 * 客户端
 *
 * @author lijun
 * @since 2018-04-09 9:54
 */
public class Client {
    public static void main(String[] args) {

        //中介者
        ConcreteMediator mediator = new ConcreteMediator();

        //同事对象
        ConcreteColleagueA concreteColleagueA = new ConcreteColleagueA(mediator);
        ConcreteColleagueB concreteColleagueB = new ConcreteColleagueB(mediator);

        //中介者设置同事对象
        mediator.setConcreteColleagueA(concreteColleagueA);
        mediator.setConcreteColleagueB(concreteColleagueB);

        System.out.println( "==========设置A影响B==========");
        concreteColleagueA.setNumber(100, mediator);
        System.out.println("concreteColleagueA: "+concreteColleagueA.getNumber());
        System.out.println("concreteColleagueB: "+concreteColleagueB.getNumber());

        System.out.println( "==========设置B影响A==========");
        concreteColleagueB.setNumber(1000, mediator);

        System.out.println("concreteColleagueB: "+concreteColleagueB.getNumber());
        System.out.println("concreteColleagueA: "+concreteColleagueA.getNumber());

    }
}
