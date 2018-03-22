package com.junli.examples.login.old;

/**
 * @author lijun
 * @since 2018-03-21 16:59
 */
public interface ILoginService {

    /**
     * 注册方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public void regist(String username, String password);


    /**
     * 登录的方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public void login(String username, String password);

}
