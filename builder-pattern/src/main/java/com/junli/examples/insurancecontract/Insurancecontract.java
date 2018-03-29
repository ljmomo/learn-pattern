package com.junli.examples.insurancecontract;

/**
 * 保险合同对象
 *
 * @author lijun
 * @since 2018-03-29 13:18
 */
public class Insurancecontract {

    /**
     * 保险合同编号
     */
    private String contractId;

    /**
     * 被保人名称 同一份保险合同，要么跟人员签订，要么跟公司签订，也就是说，“被保险人员”和“被保公司"
     * 这个两个属性不可能同时有值。
     */
    private String personName;

    /**
     * 被保公司
     */
    private String companyName;

    /**
     * 保险开始生效的时间
     */
    private long beginDate;

    /**
     * beginDate< endDate
     * 保险失效时间
     */
    private long endDate;


    /**
     * 其他数据
     */
    private String otherData;


     Insurancecontract(ConcreteBuilder concreteBuilder) {
       this.contractId = concreteBuilder.getContractId();
       this.beginDate = concreteBuilder.getBeginDate();
       this.companyName = concreteBuilder.getCompanyName();
       this.endDate = concreteBuilder.getEndDate();
       this.otherData = concreteBuilder.getOtherData();
       this.personName = concreteBuilder.getPersonName();
    }

    /**
     * 保险合同的某些操作
     */
    public void someOperation() {
        System.out.println("一些操作 " + this.contractId);
    }
}
