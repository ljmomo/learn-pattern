package com.junli.examples.person;

/**
 * DecoratorPersonA(实际的装饰对象，实现具体要被装饰对象添加的功能)
 *
 * @author lijun
 * @since 2018-03-22 10:52
 */
public class DecoratorPersonA implements Decorator {
    private Person person;

    public DecoratorPersonA(Person person) {
        this.person = person;
    }

    /**
     * 添加 上菜
     */
    private void washHands() {
        System.out.println("洗手。。。");
    }

    @Override
    public void eat() {
        washHands();
        person.eat();
    }

}
