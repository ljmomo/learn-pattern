package com.junli.examples.insurancecontract;

/**
 * @author lijun
 * @since 2018-03-29 15:09
 */
public class ClientMergeBuilder {
    public static void main(String[] args) {
        InsurancecontractMergeBuilder.ConcreteBuilder concreteBuilder = new InsurancecontractMergeBuilder
                .ConcreteBuilder("2000", 1234L, 4567L);
        InsurancecontractMergeBuilder insurancecontractMergeBuilder = concreteBuilder.setCompanyName("X")
                .setOtherData("OF").build();
        insurancecontractMergeBuilder.someOperation();
    }
}
