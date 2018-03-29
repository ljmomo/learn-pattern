### 1. 定义  
>将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
### 2.结构  
![https://github.com/ljmomo/learn-pattern/blob/master/builder-pattern/src/main/java/com/junli/structure/structure.png](https://github.com/ljmomo/learn-pattern/blob/master/builder-pattern/src/main/java/com/junli/structure/structure.png)
- Builder：生成器接口，定义创建一个Product对象所需要的各个部件的操作。
- ConcreteBuilder：具体的生成器实现，实现各个部件的创建，并负责组装Product对象的各个部件，同时还提供一个让用户获取组装完成后的产品对象的方法。
- Director：指导者，也被称导向者，主要用来使用Builder接口，以一个统一的过程来构建所需要的Product对象。
- Product：产品，表示被生成器构建的复杂对象，包含多个部件。

### 3. 实例
下面以导出数据为例来使用生成器模式：通常在导出数据上，会有一些约束的方式，比如导出成文本格式、数据库备份形式、Excel格式、Xml格式等。通常对于具体的导出内容和格式是有要求的，加入现在有如下要求，简单描述一下：
- 导出的文件，不管是什么格式，都分成3个部分，分别是文件头、文件体、文件尾。
- 在文件头部分，需要描述如下信息：分公司或者门市编号、导出数据的日期。
- 在文件体部分，需要描述如下信息：表名称，然后分条描述数据。
- 在文件尾部分，需要描述如下信息：输出人。


1. 下面将描述文件各个部分的数据对象定义出来。

```
/**
 * 描述输出到文件头的内容的对象
 * @author lijun
 * @since 2018-03-29 10:10
 */
public class ExportHeaderModel {
    /**
     * 分公司或者门市编号
     */
    private String depId;
    /**
     * 导出数据的日期
     */
    private String exportDate;

    public String getDepId() {
        return depId;
    }
    public void setDepId(String depId) {
        this.depId = depId;
    }
    public String getExportDate() {
        return exportDate;
    }
    public void setExportDate(String exportDate) {
        this.exportDate = exportDate;
    }
}

```


```
/**
 * 描述输出数据的对象
 * @author lijun
 * @since 2018-03-29 10:11
 */
public class ExportDataModel {
    /**
     * 产品编号
     */
    private String productId;
    /**
     * 销售价格
     */
    private double price;
    /**
     * 销售数量
     */
    private double amount;

    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
```


```
/**
 * 描述输出到文件尾的内容的对象
 * @author lijun
 * @since 2018-03-29 10:12
 */
public class ExportFooterModel {
    /**
     * 输出人
     */
    private String exportUser;

    public String getExportUser() {
        return exportUser;
    }

    public void setExportUser(String exportUser) {
        this.exportUser = exportUser;
    }
}

```


2. 定义Builder接口，主要是把导出各种格式文件的处理过程的步骤定义出来，每个步骤负责构建最终导出文件的一部分。示例代码如下：


```
**
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
```


3.  具体的生成器实现。
 
导出到文本文件的的生成器实现。示例代码如下：

```
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
```


导出到Xml文件的的生成器实现。示例代码如下：

```
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
```


4. 指导者。有了具体的生成器实现后，需要由指导者来指导它进行具体的产品构建。示例代码如下：


```
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

```
5. 客户端测试代码如下：

```
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

```

使用生成器模式构建复杂对象。
> 考虑这样一个实际应用，要创建一个保险合同的对象，里面有很多属性的值都有约束，要求创建出来的对象满足这些约束规则，约束规则比如，保险合同通常情况下可以和个人签订，也可以和某个公司签订，但是一份保险合同不能同时与个人和公司签订。这个对象里面有很多类似这样的约束，那么如何来创建这个对象呢？    
要想简洁直观，安全性好，又具有很好的扩展性的来创建这个对象的话，一个比较好的选择就是用Builder模式，把复杂的创建过程通过Builder来实现。   
采用Builder模式来构建复杂的对象，通常会对Builder模式进行一定的简化，因为目标明确，就是创建某个复杂对象，因此做适当简化会使程序更加简洁。大致简化如下:
- 使用Builder模式来创建某个对象，因此就没有必要再定义一个Builder接口，直接提供一个具体的构建器类就可以了。
- 对于创建一个复杂的对象，可能会有很多种不同的选择和步骤，干脆去掉“指导者”，把指导者的功能和Client的功能合并起来，也就是说,Client这个时候就相当于指导者，它来指导构建器类去构建需要的复杂对象。为了实例简单，先不去考虑约束的实现，只是考虑如何通过Builder模式来构建复杂对象。
1. 使用Builder模式来构建复杂对象，先不考虑带约束。

（1）保险合同对象 

```
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
```
（1）构建保险合同对象的构建器 ConcreteBuilder


```
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
        return new Insurancecontract(this);
    }

}
```
（3）Client 
```
public class Client {
    public static void main(String[] args) {

        ConcreteBuilder concreteBuilder = new ConcreteBuilder("1000", 8999L, 67890L);
        Insurancecontract insurancecontract = concreteBuilder.setPersonName("LIJUN").setOtherData("Test").build();
        insurancecontract.someOperation();
    }
}

```
2. 使用Builder模式来构建复杂对象，考虑带约束规则。   
   带约束规则的实现和刚才实现的并没有什么不同，只是需要在刚才的实现上把约束加上去。仅仅需要在ConcreteBuilder的方法build加上约束。

```
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
```
2. 进一步，把构建对象和被构建对象合并。   
     把构建器合并到合同对象中作为内部类。
```
/**
 * 保险合同对象
 *
 * @author lijun
 * @since 2018-03-29 13:18
 */
public class InsurancecontractMergeBuilder {

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


   private   InsurancecontractMergeBuilder(ConcreteBuilder concreteBuilder) {
       this.contractId = concreteBuilder.getContractId();
       this.beginDate = concreteBuilder.getBeginDate();
       this.companyName = concreteBuilder.getCompanyName();
       this.endDate = concreteBuilder.getEndDate();
       this.otherData = concreteBuilder.getOtherData();
       this.personName = concreteBuilder.getPersonName();
    }


    /**
     *构建保险合同对象的构建器 作为保险合同的类级内部内
     */
    public static class ConcreteBuilder {

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
        public InsurancecontractMergeBuilder build() {
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

            return new InsurancecontractMergeBuilder(this);
        }

    }


    /**
     * 保险合同的某些操作
     */
    public void someOperation() {
        System.out.println("一些操作 " + this.contractId);
    }
}

```


ClientMergeBuilder
```
public class ClientMergeBuilder {
    public static void main(String[] args) {
        InsurancecontractMergeBuilder.ConcreteBuilder concreteBuilder = new InsurancecontractMergeBuilder
                .ConcreteBuilder("2000", 1234L, 4567L);
        InsurancecontractMergeBuilder insurancecontractMergeBuilder = concreteBuilder.setCompanyName("X")
                .setOtherData("OF").build();
        insurancecontractMergeBuilder.someOperation();
    }
}

```

### 4. 本质
> 分离整体构建算法和部件构造。
### 5. 总结
1. 优点
- 松散耦合   
生成器模式可以用同一个构建算法构建出表现上完全不同的产品，实现产品构建和产品表现上的分离。生成器模式正是把产品构建的过程独立出来，使它和具体产品的表现分松散耦合，从而使得构建算法可以复用，而具体产品表现也可以很灵活地、方便地扩展和切换。
- 可以很容易的改变产品的内部表示   
在生成器模式中，由于Builder对象只是提供接口给Director使用，那么具体部件创建和装配方式是被Builder接口隐藏了的，Director并不知道这些具体的实现细节。这样一来，要想改变产品的内部表示，只需要切换Builder接口的具体实现即可，不用管Director，因此变得很容易。
- 更好的复用性   
生成器模式很好的实现构建算法和具体产品实现的分离。这样一来，使得构建产品的算法可以复用。同样的道理，具体产品的实现也可以复用，同一个产品的实现，可以配合不同的构建算法使用。

### 6. 参考
 >本文参考了《研磨设计模式》
 
 
 [源码地址](https://github.com/ljmomo/learn-pattern) builder-pattern