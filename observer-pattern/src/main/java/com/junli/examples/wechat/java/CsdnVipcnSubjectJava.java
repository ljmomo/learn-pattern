package com.junli.examples.wechat.java;

import java.util.Observable;

/**
 * CSDN公众号主题  当发布文章后通知订阅者
 * @author lijun
 * @since 2018-03-23 16:41
 */
public class CsdnVipcnSubjectJava extends Observable {
    /**
     * 文章
     */
    private String context;


    public String getContext() {
        return context;
    }

    /**
     * 发布文章
     *
     * @param context 文章内容
     */
    public void publishContext(String context) {
        this.context = context;
        //下面这这一部必须有
        this.setChanged();
        this.notifyObservers(this.context);
    }
}
