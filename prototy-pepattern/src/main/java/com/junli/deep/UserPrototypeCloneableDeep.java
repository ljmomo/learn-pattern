package com.junli.deep;

import com.junli.simple.Phone;

import java.io.*;
import java.util.Date;

/**
 * @author lijun
 * @since 2018-03-10 23:44
 */
public class UserPrototypeCloneableDeep  implements Cloneable ,Serializable{
    private static final long serialVersionUID = -3209761451599706716L;
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
    public Object clone() {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bis);
            UserPrototypeCloneableDeep  userPrototypeCloneableDeep= (UserPrototypeCloneableDeep)ois.readObject();
            userPrototypeCloneableDeep.setBirthday((Date) userPrototypeCloneableDeep.getBirthday().clone());
            userPrototypeCloneableDeep.setPhone((Phone) userPrototypeCloneableDeep.getPhone().clone());
            return userPrototypeCloneableDeep;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
