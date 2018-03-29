package com.junli.examples;

import java.util.List;
import java.util.Map;

/**
 * 指导者，指导使用生成器的接口来构建输出的文件对象
 * @author lijun
 * @since 2018-03-29 10:29
 */
public class Director {
    /**
     * 持有当前需要的使用的生成器对象
     */
    private Builder builder;

    /**
     * 构造方法，传入生成器对象
     *
     * @param builder
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(ExportHeaderModel ehm,
                          Map<String, List<ExportDataModel>> mapData, ExportFooterModel efm) {
        //1.先构建Header
        builder.buildHeader(ehm);

        //2.然后构建Body
        builder.buildBody(mapData);

        //3.再构建Footer
        builder.buildFooter(efm);
    }
}
