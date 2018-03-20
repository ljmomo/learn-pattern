package com.junli;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目经理
 * @author lijun
 * @since 2018-03-19 17:51
 */
public class Leader {

    /**
     * 员工集合
     */
    private Map<String,IDeveloper> targets = new HashMap<String,IDeveloper>();

    public Leader() {
        targets.put("login",new DeveloperA());
        targets.put("encrypt",new DeveloperB());
    }

    /**
     *项目经理不干活 委派给开发者
     * @param command 命令
     */
    public void  doing(String command){
        targets.get(command).doing(command);
    }
}
