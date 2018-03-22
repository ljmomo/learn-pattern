package com.junli.examples.login.upgrede;

import com.junli.examples.login.old.ILoginService;

/**
 * 第三方登录
 *
 * @author lijun
 * @since 2018-03-20 15:42
 */
public interface IThridLoginService extends ILoginService {

    /**
     * QQ登录
     *
     * @param openId 第三方openid
     */
    public void loginForQQ(String openId);

    /**
     * 微信登录
     *
     * @param openId 第三方openid
     */
    public void loginForWechat(String openId);

}
