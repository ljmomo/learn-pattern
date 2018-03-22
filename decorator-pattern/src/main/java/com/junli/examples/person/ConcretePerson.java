package com.junli.examples.person;

/**
 * 一般人（ConcreteComponent）
 * @author lijun
 * @since 2018-03-22 10:45
 */
public class ConcretePerson  implements Person {
    @Override
    public void eat() {
        System.out.println("吃饭。。。");
    }
}
