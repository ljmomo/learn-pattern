package com.junli.structure;

/**
 * 生成器接口，定义创建一个产品对象所需的各个部件的操作
 * @author lijun
 * @since 2018-03-28 17:26
 */
public interface Builder {
  
    /** 
     * 示意方法，构建某个部件 
     */  
    public void buildPart();  
} 