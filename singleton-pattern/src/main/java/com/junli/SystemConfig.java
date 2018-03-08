package com.junli;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lijun
 * @since 2018-03-08 10:32
 */
public class SystemConfig {
    /**
     * 类型
     */
    private String type;
    /**
     * 个数
     */
    private int num;

    public SystemConfig() {
        readConfig();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    /**
     * 读取配置文件
     */
    private void readConfig() {
        Properties properties = new Properties();
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("system_config.properties");
            properties.load(resourceAsStream);
            String type = properties.getProperty("system.type");
            String num = properties.getProperty("system.num");
            this.type = type;
            //默认配置文件值一定存在
            this.num = Integer.parseInt(num);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
