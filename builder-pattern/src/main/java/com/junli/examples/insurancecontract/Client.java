package com.junli.examples.insurancecontract;

/**
 * @author lijun
 * @since 2018-03-29 14:29
 */
public class Client {
    public static void main(String[] args) {

        ConcreteBuilder concreteBuilder = new ConcreteBuilder("1000", 8999L, 67890L);
        Insurancecontract insurancecontract = concreteBuilder.setPersonName("LIJUN").setOtherData("Test").build();
        insurancecontract.someOperation();
    }
}
