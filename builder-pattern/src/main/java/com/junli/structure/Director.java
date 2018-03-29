package com.junli.structure;

/**
 * 指导者，指导使用生成器的接口来构建产品对象
 *
 * @author lijun
 * @since 2018-03-28 17:30
 */
public class Director {
    /**
     * 持有当前需要使用的生成器对象
     */
    private Builder builder;

    /**
     * 构造方法，传人生成器对象
     *
     * @param builder
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 示意方法，指导生成器构建最终的产品对象
     */
    public void construct() {
        //通过使用生成器接口来构建最终的产品对象
        builder.buildPart();

    }
}
