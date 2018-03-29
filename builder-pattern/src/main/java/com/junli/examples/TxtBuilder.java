package com.junli.examples;

import java.util.List;
import java.util.Map;

/**
 * 实现导出文件到文本文件的生成器对象
 * @author lijun
 * @since 2018-03-29 10:24
 */
public class TxtBuilder implements Builder {
    /**
     * 用来记录构建的文件的内容，相当于产品
     */
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        buffer.append(ehm.getDepId() + "," + ehm.getExportDate() + "\n");
    }

    @Override
    public void buildBody(Map<String, List<ExportDataModel>> mapData) {
        for (String tablName : mapData.keySet()) {

            //先拼接表名
            buffer.append(tablName + "\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tablName)) {
                buffer.append(edm.getProductId() + "," + edm.getPrice() + "," + edm.getAmount() + "\n");
            }
        }
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        buffer.append(efm.getExportUser());
    }

    public StringBuffer getResult() {
        return buffer;
    }

}
