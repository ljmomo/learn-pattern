package com.junli.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标对象，它知道观察它的观察者，并提供注册和删除观察者的接口
 * @author lijun
 * @since 2018-03-23 10:06
 */
public class Subject {
    /**
     * 用来保存注册的观察者
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * 注册观察者对象
     * @param observer 观察者
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * 删除观察者
     * @param observer 观察着对象
     */
    public void detach(Observer observer){
        observers.remove(observer);
    }

    /**
     * 通知所有观察者
     */
    public void nodifyObservers(){
      observers.stream().forEach(observer -> observer.update(this));
    }

}
