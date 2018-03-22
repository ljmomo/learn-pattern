package com.junli.structure;

/**
 * 装饰器具体实现对象，向组件对象添加状态
 * @author lijun
 * @since 2018-03-21 10:50
 */
public class ConcreteDecoratorB extends Decorator {

    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    /**
     * 需要添加的职责
     */

    public void addBehavior(){
        //需要添加的职责实现
    }

    @Override
    public void operation() {
        super.operation();
        addBehavior();
    }
}
