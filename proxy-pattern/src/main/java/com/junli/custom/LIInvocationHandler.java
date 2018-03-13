package com.junli.custom;

import java.lang.reflect.Method;

/**InvocationHandler
 * 自定义的
 * @author lijun
 * @since 2018-03-12 17:02
 */
public interface LIInvocationHandler {
    /**
     *
     * @param proxy proxy
     * @param method method
     * @param args args
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
