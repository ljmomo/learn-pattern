package com.junli.structure;

/**
 * 具体观察者对象，实现更新的方法，使自身的状态和目标的状态保持一致
 * @author lijun
 * @since 2018-03-23 10:37
 */
public class ConcreteObserver implements Observer {

    /**
     * 观察者状态
     */
    private  String observerState ;
    /**
     * 更新的的接口
     *
     * @param subject 传入目标对象 方便获取相应目标对象的状态
     */
    @Override
    public void update(Subject subject) {
       //具体的更新实现
        //这里可以获取观察者的状态，使其和目标的状态的保持一致
        ConcreteSubject subject1 = (ConcreteSubject) subject;
        observerState = subject1.getSubjectState();
        System.out.println("观察者状态："+observerState);
    }
}
