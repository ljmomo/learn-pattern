package com.junli;

/**
 * @author lijun
 * @since 2018-03-27 14:47
 */
public class App {
    public static void main(String[] args) {
        Object key = "1";
        int h;
        h = key.hashCode();
        System.out.println(h);
        System.out.println(h >>> 16);
        int m = h ^ (h >>> 16);
        System.out.println(m);
        System.out.println(3 ^ 4);
        System.out.println(1 << 4);

    }



}
