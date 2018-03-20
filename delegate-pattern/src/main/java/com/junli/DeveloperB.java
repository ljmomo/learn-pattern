package com.junli;

/**
 *开发者B
 * @author lijun
 * @since 2018-03-19 17:51
 */
public class DeveloperB implements IDeveloper {
    /**
     * @param command
     */
    @Override
    public void doing(String command) {
        System.out.println("我开发者B，我开始做："+command);
    }
}
