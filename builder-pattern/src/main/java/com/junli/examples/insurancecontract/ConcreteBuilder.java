package com.junli.examples.insurancecontract;

/**
 * 构建保险合同对象的构建器
 *
 * @author lijun
 * @since 2018-03-29 14:11
 */
public class ConcreteBuilder {

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
     * 保险失效时间
     */
    private long endDate;


    /**
     * 其他数据
     */
    private String otherData;

    public ConcreteBuilder(String contractId, long beginDate, long endDate) {
        this.contractId = contractId;
        this.beginDate = beginDate;
        this.endDate = endDate;
    }

    public ConcreteBuilder setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public ConcreteBuilder setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public ConcreteBuilder setOtherData(String otherData) {
        this.otherData = otherData;
        return this;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getPersonName() {
        return personName;
    }


    public String getCompanyName() {
        return companyName;
    }


    public long getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(long beginDate) {
        this.beginDate = beginDate;
    }

    public long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }

    public String getOtherData() {
        return otherData;
    }

    /**
     * 构建真正的对象并返回
     *
     * @return 构建的保险合同对象
     */
    public Insurancecontract build() {
        if (contractId == null || contractId.trim().length() == 0) {
            throw new IllegalArgumentException("合同编号不能为空！");
        }
        boolean personIs = personName == null || personName.trim().length() == 0;
        boolean companyIs = companyName == null || companyName.trim().length() == 0;

        if (personIs && companyIs) {
            throw new IllegalArgumentException("一份合同不能同时和个人和公司同签！");
        }

        if (personIs == false && companyIs == false) {
            throw new IllegalArgumentException("一份合同不能没有签订对象");
        }

        if (beginDate <= 0) {
            throw new IllegalArgumentException("保险合同必须有开始日期");
        }
        if (endDate<= 0) {
            throw new IllegalArgumentException("保险合同必须有失效日期");
        }
        if (endDate<= beginDate) {
            throw new IllegalArgumentException("保险合同失效日期必须大于生效日期");
        }

        return new Insurancecontract(this);
    }

}
