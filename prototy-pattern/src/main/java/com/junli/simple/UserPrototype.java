package com.junli.simple;

import java.util.Date;

/**
 * @author lijun
 * @since 2018-03-09 14:27
 */
public class UserPrototype {
    private  String name;
    private  int age;
    private Date birthday;

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


    public UserPrototype clonePrototype(){
        UserPrototype prototype = new UserPrototype();
        prototype.setName(this.name);
        prototype.setAge(this.age);
        prototype.setBirthday(this.birthday);
        return prototype;
    }
}
