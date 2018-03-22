package com.junli.examples.person;

/**
 * DecoratorPersonA(实际的装饰对象，实现具体要被装饰对象添加的功能)
 *
 * @author lijun
 * @since 2018-03-22 10:52
 */
public class DecoratorPersonB implements Decorator {

    private Person person;

    public DecoratorPersonB(Person person) {
        this.person = person;
    }


    private void addFruit() {
        System.out.println("吃水果。。。");
    }

    @Override
    public void eat() {
        person.eat();
        addFruit();
    }
}
