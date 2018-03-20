package com.junli.structure.example.object;

import com.junli.structure.example.LoginService;
import com.junli.structure.example.ThridLoginService;

/**
 * 微信登录适配
 *
 * @author lijun
 * @since 2018-03-20 15:54
 */
public class LoginForWechatAdapter implements ThridLoginService {

    /**
     * 被适配的对象
     */
    LoginService loginService;

    /**
     * 构造方法
     *
     * @param loginService loginService
     */
    public LoginForWechatAdapter(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 第三方登录
     *
     * @param openId 第三方openid
     */
    @Override
    public void loginThrid(String openId) {
        System.out.println("微信 注册登录");
        loginService.regist(openId, null);
        loginService.login(openId, null);
    }
}
