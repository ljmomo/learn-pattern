package com.junli;

import java.util.HashMap;

public class HashMapInfiniteLoop {
 
    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2,0.75f);
    public static void main(String[] args) {  
        map.put(5, "C");
 
        new Thread("Thread1") {
            @Override
            public void run() {  
                map.put(7, "B");  
                System.out.println(map);  
            };  
        }.start();  
        new Thread("Thread2") {
            @Override
            public void run() {  
                map.put(3,"A");
                System.out.println(map);  
            };  
        }.start();
        String s = map.get(7);
        System.out.println(s);

    }  
}