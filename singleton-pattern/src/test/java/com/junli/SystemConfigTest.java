package com.junli;

import com.junli.hungry.SystemConfig;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * @author lijun
 * @since 2018-03-08 10:45
 */
public class SystemConfigTest {

    @Test
    public void testConfig() {
        SystemConfig systemConfig = new SystemConfig();
        System.out.println("配置类型：" + systemConfig.getType() + "  配置个数：" + systemConfig.getNum());
    }

    @Test
    public void testHungry() {
        SystemConfig systemConfig = SystemConfig.getInstance();
        System.out.println("配置类型：" + systemConfig.getType() + "  配置个数：" + systemConfig.getNum());
    }

    /**
     * 并发单例
     *
     * @throws InterruptedException
     */
    @Test
    public void testConcurrent() throws InterruptedException {
        System.out.println("100准备就绪.......");
        long start = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    //com.junli.hungry.SystemConfig instance = com.junli.hungry.SystemConfig.getInstance();
                    //com.junli.lazy.SystemConfig instance = com.junli.lazy.SystemConfig.getInstance();
                    com.junli.cache.SystemConfig instance = com.junli.cache.SystemConfig.getInstance();
                    //RegisterMap instance = RegisterMap.getInstance(null);
                    System.out.println("对象：" + instance);
                    countDownLatch.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();

        }
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("100个线程已经执行完毕！总耗时：" + (end - start));
    }

    /**
     * 缓存式
     */
    @Test
    public void testCacheConfig() {
        com.junli.cache.SystemConfig systemConfig = com.junli.cache.SystemConfig.getInstance();
        System.out.println("配置类型：" + systemConfig.getType() + "  配置个数：" + systemConfig.getNum());
    }

    /**
     * 序列化测试
     */
    @Test
    public void testSeriableConfig() {
        com.junli.seriable.SystemConfig s1 = null;
        com.junli.seriable.SystemConfig s2 = com.junli.seriable.SystemConfig.getInstance();

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("SystemConfig.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(s2);
            objectOutputStream.flush();
            objectOutputStream.close();

            FileInputStream fileInputStream = new FileInputStream("SystemConfig.obj");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            s1 = (com.junli.seriable.SystemConfig) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println(s1);
            System.out.println(s2);

            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}