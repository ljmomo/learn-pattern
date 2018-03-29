package com.junli.examples;

import java.util.List;
import java.util.Map;

/**
 * 实现导出文件到Xml文件的生成器对象
 *
 * @author lijun
 * @since 2018-03-29 10:27
 */
public class XmlBuilder implements Builder {
    /**
     * 用来记录构建的文件的内容，相当于产品
     */
    private StringBuffer buffer = new StringBuffer();

    @Override
    public void buildHeader(ExportHeaderModel ehm) {
        buffer.append("<?xml version='1.0' encoding='UTF-8'?>\n");
        buffer.append("<Report>\n");
        buffer.append("\t<Header>\n");
        buffer.append("\t\t<DepId>" + ehm.getDepId() + "</DepId>\n");
        buffer.append("\t\t<ExportDate>" + ehm.getExportDate() + "</ExportDate>\n");

        buffer.append("\t</Header>\n");
    }

    @Override
    public void buildBody(Map<String, List<ExportDataModel>> mapData) {
        buffer.append("\t<Body>\n");
        for (String tablName : mapData.keySet()) {
            //先拼接表名
            buffer.append("\t\t<Datas TableName=\"" + tablName + "\">\n");
            //然后循环拼接具体数据
            for (ExportDataModel edm : mapData.get(tablName)) {

                buffer.append("\t\t\t<Data>\n");

                buffer.append("\t\t\t\t<ProductId>" + edm.getProductId() + "</ProductId>\n");
                buffer.append("\t\t\t\t<Price>" + edm.getPrice() + "</Price>\n");
                buffer.append("\t\t\t\t<Amount>" + edm.getAmount() + "</Amount>\n");

                buffer.append("\t\t\t</Data>\n");
            }

            buffer.append("\t\t</Datas>\n");
        }
        buffer.append("\t</Body>\n");
    }

    @Override
    public void buildFooter(ExportFooterModel efm) {
        buffer.append("\t<Footer>\n");
        buffer.append("\t\t<ExportUser>" + efm.getExportUser() + "</ExportUser>\n");
        buffer.append("\t</Footer>\n");
        buffer.append("</Report>\n");
    }

    public StringBuffer getResult() {
        return buffer;
    }

}

