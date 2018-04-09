package com.junli.structure;

/**中介者接口
 * @author lijun
 * @since 2018-04-08 17:35
 */
public interface Mediator {
    /**
     *同事对象在自身改变的情况的下通知中介者的方法
     * 让中介者去与其他同事交互
     * @param colleague 同事对象
     */
   public void charged(Colleague colleague);
}
