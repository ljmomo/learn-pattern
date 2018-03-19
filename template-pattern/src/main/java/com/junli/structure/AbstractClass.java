package com.junli.structure;

/**
 * 模板方法 原语操作的抽象类
 * @author lijun
 * @since 2018-03-16 17:23
 */
public abstract class AbstractClass {
    /**
     * 原语操作1
     */
   public abstract void doPrimitiveOperation1();

    /**
     * 原语操作2
     */
    public abstract void doPrimitiveOperation2();

    /**
     * 模板方法定义算法骨架
     */
    public  final void  templateMethod(){
        doPrimitiveOperation1();
        doPrimitiveOperation2();
    }

}
