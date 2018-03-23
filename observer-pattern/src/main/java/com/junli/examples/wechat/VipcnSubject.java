package com.junli.examples.wechat;

import java.util.ArrayList;
import java.util.List;

/**
 * 微信公众号主题
 *
 * @author lijun
 * @since 2018-03-23 13:31
 */
public class VipcnSubject {

    private List<VipcnObserver> observers = new ArrayList<>();

    /**
     * 关注
     *
     * @param observer 观察者
     */
    public void attention(VipcnObserver observer) {
        observers.add(observer);
    }

    /**
     * 取消关注
     *
     * @param observer
     */
    public void canelAttention(VipcnObserver observer) {
        observers.remove(observer);
    }

    /**
     * 通知所有的订阅者
     */
    public void notifyVipcnObserver() {
        observers.stream().forEach(observer -> observer.view(this));
    }
}
