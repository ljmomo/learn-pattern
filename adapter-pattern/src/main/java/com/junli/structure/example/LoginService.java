package com.junli.structure.example;

/**
 * 稳定的注册和登录
 *
 * @author lijun
 * @since 2018-03-20 15:35
 */
public class LoginService {
    /**
     * 注册方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public void regist(String username, String password) {
        System.out.println("恭喜你注册成功！");
    }


    /**
     * 登录的方法
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public void login(String username, String password) {
        System.out.println("恭喜你登录成功！");
    }
}
