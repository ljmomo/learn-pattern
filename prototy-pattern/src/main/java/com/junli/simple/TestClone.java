package com.junli.simple;

import java.util.ArrayList;

/**
 * @author lijun
 * @since 2018-03-10 22:44
 */
public class TestClone  implements Cloneable{

    private  String name;
    private  int age;

    private ArrayList myList;

    public ArrayList getMyList() {
        return myList;
    }

    public void setMyList(ArrayList myList) {
        this.myList = myList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
