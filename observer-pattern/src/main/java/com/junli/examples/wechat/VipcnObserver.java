package com.junli.examples.wechat;

/**
 * 关注者接口
 *
 * @author lijun
 * @since 2018-03-23 13:33
 */
public interface VipcnObserver {
    /**
     * 查看文章
     */
    void view(VipcnSubject subject);
}
