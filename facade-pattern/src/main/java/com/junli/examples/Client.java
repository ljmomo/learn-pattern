package com.junli.examples;

        import com.junli.examples.facade.Phone;

/**
 * @author lijun
 * @since 2018-03-27 17:12
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.start();
        phone.shutDwon();

    }
}
