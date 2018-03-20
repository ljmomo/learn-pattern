package com.junli.structure.example.extendss;

import com.junli.structure.example.LoginService;
import com.junli.structure.example.ThridLoginService;

/**
 * 继承实现QQ登录
 * @author lijun
 * @since 2018-03-20 15:54
 */
public class LoginForQQExtendsAdapter extends LoginService  implements ThridLoginService {

    @Override
    public void loginThrid(String openId) {
        System.out.println("QQ 注册登录");
        super.regist(openId,null);
        super.login(openId,null);
    }
}
