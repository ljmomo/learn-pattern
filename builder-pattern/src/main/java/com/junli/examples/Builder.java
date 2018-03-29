package com.junli.examples;

import java.util.List;
import java.util.Map;

/**
 * 生成器接口，定义创建一个输出文件对象所需的各个部件的操作
 * @author lijun
 * @since 2018-03-29 10:17
 */
public interface Builder {
    /**
     * 构建输出文件的Header部分
     * @param ehm
     */
    public void buildHeader(ExportHeaderModel ehm);

    /**
     * 构建输出文件的Body部分
     * @param mapData
     */
    public void buildBody(Map<String,List<ExportDataModel>> mapData);

    /**
     * 构建输出文件的Footer部分
     * @param efm
     */
    public void buildFooter(ExportFooterModel efm);
}
