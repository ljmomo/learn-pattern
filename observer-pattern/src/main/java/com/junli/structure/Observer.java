package com.junli.structure;

/**
 * 观察者接口 定义一个更新的接口 给那些在目标发生改变的时候被通知的对象
 * @author lijun
 * @since 2018-03-23 10:09
 */
public interface Observer {
    /**
     *更新的的接口
     * @param subject 传入目标对象 方便获取相应目标对象的状态
     */
     void update(Subject subject);
}
