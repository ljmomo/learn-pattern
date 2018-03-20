package com.junli.structure.object;

/**
 * 适配器
 * @author lijun
 * @since 2018-03-20 11:23
 */
public class Adapter implements Target{

    /**
     * 持有需要被适配对象的接口
     */
    private  Adaptee adaptee;

    /**
     * 构造方法传入需要被适配的对象
     * @param adaptee 被适配的对象
     */
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    /**
     * 示意方法 客户端请求处理的方法
     */
    @Override
    public void request() {
         //转调已经实现了的方法进行适配
        adaptee.specificRequest();
    }
}
