package com.junli.structure.extendss;

/**
 * 使用适配器的客户端
 * @author lijun
 * @since 2018-03-20 13:15
 */
public class Client {

    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.request();
    }

}
