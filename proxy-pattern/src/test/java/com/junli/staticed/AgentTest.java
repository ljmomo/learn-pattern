package com.junli.staticed;


import com.junli.cglib.AgentCglib;
import com.junli.custom.AgentCustomDynamic;
import com.junli.dynamic.AgentDynamic;
import org.junit.Test;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author lijun
 * @since 2018-03-12 14:29
 */
public class AgentTest {

    @Test
    public void sing(){
        Star star = new JackyCheung();
        Agent agent = new Agent(star);
        agent.confer();
        agent.signContract();
        agent.sing();
        agent.collectMoney();
    }

    /**
     * JDK 自带的动态代理
     */
    @Test
    public void singDynamic(){
        AgentDynamic agentDynamic = new AgentDynamic();
        Star star  = (Star)agentDynamic.getInstance(new JackyCheung());
        System.out.println(star.getClass());
        star.sing();
        //原理：
        //1、拿到被代理对象的引用，并且获取到它的所有的接口，反射获取
        //2、JDK Proxy类重新生成一个新的类、同时新的类要实现被代理类所有实现的所有的接口
        //3、动态生成Java代码，把新加的业务逻辑方法由一定的逻辑代码去调用（在代码中体现）
        //4、编译新生成的Java代码.class
        //5、再重新加载到JVM中运行
        //以上这个过程就叫字节码重组

        //JDK中有个规范，只要要是$开头的一般都是自动生成的
        byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy4", new Class[]{Star.class});
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\$Proxy4.class");
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     *CGlib 代理
     */
    @Test
    public void singCglib() {
        AgentCglib agentCglib = new AgentCglib();
        Star star  = (Star)agentCglib.getInstance(JackyCheung.class);
        System.out.println(star.getClass());
        star.sing();
    }

    /**
     * 自己定义的动态代理
     */
    @Test
    public void singCustom() {
        AgentCustomDynamic agentCustomDynamic = new AgentCustomDynamic();
        Star star  = (Star)agentCustomDynamic.getInstance(new JackyCheung());
        System.out.println(star.getClass());
        star.sing();
    }

}