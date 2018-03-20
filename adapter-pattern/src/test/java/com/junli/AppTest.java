package com.junli;

import com.junli.structure.example.LoginService;
import com.junli.structure.example.ThridLoginService;
import com.junli.structure.example.extendss.LoginForQQExtendsAdapter;
import com.junli.structure.example.object.LoginForQQAdapter;
import com.junli.structure.example.object.LoginForWechatAdapter;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void testObject() {
        //QQ
        ThridLoginService loginForQQAdapter = new LoginForQQAdapter(new LoginService());
        loginForQQAdapter.loginThrid("MMMMXXXXXXX");

        //微信
        ThridLoginService loginForWechatAdapter = new LoginForWechatAdapter(new LoginService());
        loginForWechatAdapter.loginThrid("MMMMXXXXXXX");
    }

    @Test
    public void testExtends() {
        LoginForQQExtendsAdapter loginForQQExtendsAdapter = new LoginForQQExtendsAdapter();
        loginForQQExtendsAdapter.loginThrid("MMMMXXXXXXX");
    }
}
