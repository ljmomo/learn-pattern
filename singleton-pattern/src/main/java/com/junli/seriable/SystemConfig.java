package com.junli.seriable;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

/**
 * @author lijun
 * @since 2018-03-08 13:05
 */
public class SystemConfig implements Serializable {

    /**
     * 定义一个变量来存储创建好的实例（只创建一次）
     */
    private final static SystemConfig INSTANCE = new SystemConfig();


    /**
     * 私有构造方法
     */
    public SystemConfig() {
        readConfig();
    }


    public static SystemConfig getInstance() {
        return INSTANCE;
    }


    /**
     * 类型
     */
    private String type;
    /**
     * 个数
     */
    private int num;


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

    private Object readResolve() {
        return INSTANCE;
    }

}
