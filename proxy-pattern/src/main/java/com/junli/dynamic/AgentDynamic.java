package com.junli.dynamic;

import com.junli.staticed.Star;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理的经纪人
 * @author lijun
 * @since 2018-03-12 14:57
 */
public class AgentDynamic implements InvocationHandler{
    private Star star;

    /**  获取代理对象
     * @param target star
     * @return Object
     */
  public Object getInstance(Star target){
      this.star = target;
      Class<? extends Star> aClass = target.getClass();
      return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
  }

    /**
     * 参数：
     *proxy 被代理的对象
     *method 被代理对象的方法
     *args 方法的参数
     * 返回：
     *Object 方法返回值
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;
        String name = method.getName();
         if (name.equals("sing")){
             System.out.println("经纪人代表面谈！");
             System.out.println("经纪人代表签合同！");
             object =  method.invoke(star, args);
             System.out.println("经纪人代表收尾款！");
         }
        return object;
    }
}
