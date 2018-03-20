package com.junli.structure.extendss;

/**
 * 适配器
 * @author lijun
 * @since 2018-03-20 11:23
 */
public class Adapter extends Adaptee implements Target {
    /**
     * 示意方法 客户端请求处理的方法
     */
    @Override
    public void request() {
         //转调已经实现了的方法进行适配
        super.specificRequest();
    }
}
