package com.junli.structure;

/**
 * 具体的生成器实现对象
 * @author lijun
 * @since 2018-03-28 17:26
 */
public class ConcreteBuilder implements Builder{

    private Product resultProduct;
    /**
     * 获取生成器最终构建的产品对象
     * @return Product
     */
    public Product getResultProduct() {
        return resultProduct;
    }
    /**
     * 示意方法，构建某个部件
     */
    @Override
    public void buildPart() {
        //构建某个部件的功能处理
    }
}
