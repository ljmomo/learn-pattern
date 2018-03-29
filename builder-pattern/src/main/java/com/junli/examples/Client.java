package com.junli.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lijun
 * @since 2018-03-29 10:31
 */
public class Client {
    /**
     * @param args
     */
    public static void main(String[] args) {

        //准备测试数据
        ExportHeaderModel ehm = new ExportHeaderModel();
        ehm.setDepId("一分公司");
        ehm.setExportDate("2018-03-29");

        Map<String, List<ExportDataModel>> mapData = new HashMap<String, List<ExportDataModel>>();
        List<ExportDataModel> col = new ArrayList<ExportDataModel>();

        ExportDataModel edm1 = new ExportDataModel();
        edm1.setProductId("产品001号");
        edm1.setPrice(100);
        edm1.setAmount(80);

        ExportDataModel edm2 = new ExportDataModel();
        edm2.setProductId("产品002号");
        edm2.setPrice(120);
        edm2.setAmount(280);

        ExportDataModel edm3 = new ExportDataModel();
        edm3.setProductId("产品003号");
        edm3.setPrice(320);
        edm3.setAmount(380);

        col.add(edm1);
        col.add(edm2);
        col.add(edm3);

        mapData.put("销售记录表", col);

        ExportFooterModel efm = new ExportFooterModel();
        efm.setExportUser("LIJUN");

        //测试输出到文本文件
        TxtBuilder txtBuilder = new TxtBuilder();
        //创建指导者对象
        Director director = new Director(txtBuilder);
        director.construct(ehm, mapData, efm);

        //把要输出的内容输出到控制台看看
        System.out.println("输出到文本文件的内容:" + txtBuilder.getResult().toString());

        XmlBuilder xmlBuilder = new XmlBuilder();
        Director director2 = new Director(xmlBuilder);
        director2.construct(ehm, mapData, efm);

        //把要输出的内容输出到控制台看看
        System.out.println("输出到Xml文件的内容:" + xmlBuilder.getResult().toString());
    }

}
