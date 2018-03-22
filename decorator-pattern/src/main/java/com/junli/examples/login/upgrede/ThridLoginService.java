package com.junli.examples.login.upgrede;

import com.junli.examples.login.old.ILoginService;

/**
 * @author lijun
 * @since 2018-03-21 17:16
 */
public class ThridLoginService implements IThridLoginService {

    ILoginService loginService;

    public ThridLoginService(ILoginService loginService) {
        this.loginService = loginService;
    }



    /**
     * 注册方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public void regist(String username, String password) {
        loginService.regist(username, password);
    }

    /**
     * 登录的方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @Override
    public void login(String username, String password) {
        loginService.login(username, password);
    }


    public void loginForRegist(String username, String password) {
        this.regist(username, null);
        this.login(username, null);
    }

    /**
     * QQ登录
     *
     * @param openId 第三方openid
     */
    @Override
    public void loginForQQ(String openId) {
        System.out.println("QQ 登录");
       loginForRegist(openId,null);
    }

    /**
     * 微信登录
     *
     * @param openId 第三方openid
     */
    @Override
    public void loginForWechat(String openId) {
        System.out.println("微信 登录");
        loginForRegist(openId,null);
    }


}
