package com.junli.examples.wechat.java;

import java.util.Observable;
import java.util.Observer;

/**
 * 关注者A
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverJavaA implements Observer {

    /**
     * 文章
     */
    private String context;


    /**
     * 查看文章
     */
    @Override
    public void update(Observable o, Object arg) {
       /* CsdnVipcnSubjectJava csdnVipcnSubject = (CsdnVipcnSubjectJava)o;
        context = csdnVipcnSubject.getContext();*/
        System.out.println("我是订阅者A,我收到了文章.文章内容是：" + arg);
    }
}
