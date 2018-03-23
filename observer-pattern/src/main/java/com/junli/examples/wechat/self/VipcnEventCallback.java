package com.junli.examples.wechat.self;


import com.junli.examples.core.Event;

/**
 * 观察者
 * 回调响应的逻辑，由自己实现
 *
 * @author lijun
 * @since 2018-03-23 15:20
 */
public class VipcnEventCallback {

    /**
     * 发布文件的通知
     *
     * @param e 事件
     */
    public void publishArticle(Event e) {
        System.out.println("观察者收到发布的文章，文章内容是：" + ((CsdnVipcnSubjectSelf) e.getSource()).getContext());
    }

    /**
     * 发布文件的通知
     *
     * @param e 事件
     */
    public void publishText(Event e) {
        System.out.println("观察者收到发布的文字，文字内容是：" + ((CsdnVipcnSubjectSelf) e.getSource()).getContext());
    }

}
