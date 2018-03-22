package com.junli;

import com.junli.examples.login.old.LoginService;
import com.junli.examples.login.upgrede.IThridLoginService;
import com.junli.examples.login.upgrede.ThridLoginService;
import com.junli.examples.person.*;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest{
    @Test
    public void  test(){
        IThridLoginService thridLoginService = new ThridLoginService(new LoginService());
        thridLoginService.loginForQQ("XXXMMMM");

        ThridLoginService thridLoginService2 = new ThridLoginService(thridLoginService);
        thridLoginService2.loginForWechat("WX-MMM--TTT");
    }

    @Test
    public void  testPerson(){

        System.out.println("一般人吃饭");
        Person person = new ConcretePerson();
        person.eat();

        System.out.println("\t");
        System.out.println("稍微讲究点的人吃饭");
        Decorator decoratorA = new DecoratorPersonA(person);
        decoratorA.eat();


        System.out.println("\t");
        System.out.println("比较稍微讲究点的人吃饭");
        Decorator decoratorB = new DecoratorPersonB(decoratorA);
        decoratorB.eat();
    }

}
