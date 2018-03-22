package com.junli.structure;

/**
 * 装饰器具体实现对象，向组件对象添加状态
 * @author lijun
 * @since 2018-03-21 10:50
 */
public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    /**
     * 添加状态
     */
    public String addedState;

    public String getAddedState() {
        return addedState;
    }

    public void setAddedState(String addedState) {
        this.addedState = addedState;
    }

    @Override
    public void operation() {
        super.operation();
    }
}
