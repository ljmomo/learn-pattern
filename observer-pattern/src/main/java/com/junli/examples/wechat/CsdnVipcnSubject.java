package com.junli.examples.wechat;

/**
 * CSDN公众号主题  当发布文章后通知订阅者
 *
 * @author lijun
 * @since 2018-03-23 13:41
 */
public class CsdnVipcnSubject extends VipcnSubject {
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
        this.notifyVipcnObserver();
    }
}
