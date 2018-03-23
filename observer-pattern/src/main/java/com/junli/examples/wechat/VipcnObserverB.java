package com.junli.examples.wechat;

/**
 * 关注者B
 *
 * @author lijun
 * @since 2018-03-23 13:58
 */
public class VipcnObserverB implements VipcnObserver {

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
        System.out.println("我是关注者B,我收到了文章.文章内容是：" + context);
    }
}
