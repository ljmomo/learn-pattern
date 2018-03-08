package com.junli.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lijun
 * @since 2018-03-08 13:05
 */
public class SystemConfig {


    /**
     * 唯一KEY
     */
    private final static String CACHE_MAP_KEY = "one";

    /**
     * 保存实例的地方
     */
    private static Map<String, SystemConfig> map = new ConcurrentHashMap<>();

    /**
     * 私有构造方法
     */
    private SystemConfig() {
        readConfig();
    }

    /**
     * 先从map里面取 取不到就放一个
     *
     * @return
     */
    public static synchronized SystemConfig getInstance() {
        SystemConfig systemConfig = map.get(CACHE_MAP_KEY);
        if (systemConfig == null) {
            systemConfig = new SystemConfig();
            map.put(CACHE_MAP_KEY, systemConfig);
        }
        return systemConfig;
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

}
