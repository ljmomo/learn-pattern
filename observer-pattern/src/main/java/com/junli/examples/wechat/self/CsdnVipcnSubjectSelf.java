package com.junli.examples.wechat.self;

import com.junli.examples.core.EventLisenter;

/**
 * 被观察者
 *
 * @author lijun
 * @since 2018-03-23 15:42
 */
public class CsdnVipcnSubjectSelf extends EventLisenter {
    /**
     * 文章或者文字类容
     */
    private String context;

    public String getContext() {
        return context;
    }

    /**
     * 发布文章
     *
     * @param context 内容
     */
    public void publishArtcle(String context) {
        this.context = context;
        System.out.println("发布文章。。。。");
        this.trigger(VipcnEventType.PUBLISH_ARTICLE);
    }


    /**
     * 发布文字
     *
     * @param context 内容
     */
    public void publishArtcleText(String context) {
        this.context = context;
        System.out.println("发布文字。。。。");
        this.trigger(VipcnEventType.PUBLISH_TEXT);
    }

}
