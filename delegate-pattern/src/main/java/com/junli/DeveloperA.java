package com.junli;

/**
 * @author lijun
 * @since 2018-03-19 17:51
 */
public class DeveloperA implements IDeveloper {
    /**
     * @param command
     */
    @Override
    public void doing(String command) {
        System.out.println("我是A员工，我开始做："+command);
    }
}
