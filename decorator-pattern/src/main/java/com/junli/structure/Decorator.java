package com.junli.structure;

/**
 * 装饰器接口，维持一个指向组件对象的接口对象，并定义一个与组件接口一致的方法
 * @author lijun
 * @since 2018-03-21 10:36
 */
public abstract class Decorator extends Component{

    /**
     * 持有组件对象
     */
    protected Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public  void operation(){
        component.operation();
    }
}
