package com.junli.examples.wechat;

/**
 * 关注者A
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverA implements VipcnObserver {

    /**
     * 文章
     */
    private String context;

    /**
     * 查看文章
     */
    @Override
    public void view(VipcnSubject subject) {
        CsdnVipcnSubject csdnVipcnSubject = (CsdnVipcnSubject) subject;
        context = csdnVipcnSubject.getContext();
        System.out.println("我是订阅者A,我收到了文章.文章内容是：" + context);
    }
}
