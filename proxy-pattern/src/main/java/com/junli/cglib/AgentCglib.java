package com.junli.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib动态代理实现
 * @author lijun
 * @since 2018-03-12 16:11
 */
public class AgentCglib implements MethodInterceptor {

    /**
     *
     * @param clazz clazz 被代理类的具体实现类
     * @return Object
     */
    public Object getInstance(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
       return enhancer.create();
    }
    /**
     * 拦截所有目标类方法的调用
     * 参数：
     * obj目标实例对象
     *method 目标方法的反射对象
     * args方法的参数
     * proxy代理类的实例
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object object = null;

        String name = method.getName();
        if (name.equals("sing")){
            System.out.println("经济人代表面谈！");
            System.out.println("经济人代表签合同！");
            object =  methodProxy.invokeSuper(o, objects);
            System.out.println("经济人代表收尾款！");
        }
        return object;
    }
}
