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
        targets.put("加密",new DeveloperA());
        targets.put("encrypt",new DeveloperB());
    }
    public void  doing(String command){
        targets.get(command).doing(command);
    }
}
