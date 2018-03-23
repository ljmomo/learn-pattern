package com.junli.structure;

/**
 * 具体的目标对象，辅助把有关状态存入到相应的观察者对象
 * 并在自己状态发生改变时，通知各个观察者
 * @author lijun
 * @since 2018-03-23 10:31
 */
public class ConcreteSubject extends Subject {


    /**
     * 目标对象的状态
     */
    private String subjectState;


    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
        System.out.println("目标状态："+subjectState);
        //状态改变通知所有观察者
        this.nodifyObservers();
    }
}
