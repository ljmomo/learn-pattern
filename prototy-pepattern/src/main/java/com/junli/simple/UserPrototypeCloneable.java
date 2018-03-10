package com.junli.simple;

import java.util.Date;

/**
 * @author lijun
 * @since 2018-03-09 14:27
 */
public class UserPrototypeCloneable implements Cloneable {
    public  String name;
    public  int age;
    public Date birthday;
    public Phone phone;


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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
