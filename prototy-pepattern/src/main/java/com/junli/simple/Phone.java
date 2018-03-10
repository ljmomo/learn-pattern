package com.junli.simple;

import java.io.Serializable;

/**
 * @author lijun
 * @since 2018-03-09 17:44
 */
public class Phone implements Serializable ,Cloneable{
    private static final long serialVersionUID = -8637667978831245045L;
    public String name;
    public String ys;

    public Phone(String name, String ys) {
        this.name = name;
        this.ys = ys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYs() {
        return ys;
    }

    public void setYs(String ys) {
        this.ys = ys;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Phone{" +
                "                            name:'" + name + '\'' +
                ",                             ys:'" + ys + '\'' +
                '}';
    }
}
