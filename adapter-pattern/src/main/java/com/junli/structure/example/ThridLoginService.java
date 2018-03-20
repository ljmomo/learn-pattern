package com.junli.structure.example;

/**
 * 第三方登录
 *
 * @author lijun
 * @since 2018-03-20 15:42
 */
public interface ThridLoginService {
    /**
     * 第三方登录
     *
     * @param openId 第三方openid
     */
    public void loginThrid(String openId);
}
