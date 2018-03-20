package com.junli.structure.object;

/**
 * 使用适配器的客户端
 * @author lijun
 * @since 2018-03-20 13:15
 */
public class Client {

    public static void main(String[] args) {
        //创建被适配的对象
        Adaptee adaptee = new Adaptee();
        /**
         * 创建客户端需要调用的接口对象
         */
        Target target = new Adapter(adaptee);
        target.request();

    }

}
