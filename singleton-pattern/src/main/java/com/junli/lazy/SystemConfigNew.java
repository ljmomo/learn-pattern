package com.junli.lazy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lijun
 * @since 2018-03-08 21:14
 */
public class SystemConfigNew {


    private static boolean initialized = false;

    //默认使用SystemConfigNew的时候，会先初始化内部类
    //如果没使用的话，内部类是不加载的

    /**
     * 私有构造方法
     */
    private SystemConfigNew() {
        synchronized (SystemConfigNew.class) {
            if (initialized == false) {
                initialized = !initialized;
            } else {
                throw new RuntimeException("单例已被侵犯");
            }
        }
        readConfig();
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

    /**
     * @return
     */
    public final static SystemConfigNew getInstance() {
        return LazyHolder.LAZY;
    }

    /**
     * 内部类
     */
    public static class LazyHolder {
        private final static SystemConfigNew LAZY = new SystemConfigNew();
    }
}
