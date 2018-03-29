package com.junli.simple;

import com.junli.deep.UserPrototypeCloneableDeep;
import org.junit.Test;

import java.util.Date;

/**
 * @author lijun
 * @since 2018-03-09 15:17
 */
public class UserPrototypeTest {

    @Test
    public void testClone(){
        UserPrototype prototype = new UserPrototype();
        prototype.setName("LIJUN");
        prototype.setAge(25);
        prototype.setBirthday(new Date(1520583326));

        UserPrototype prototype1 = prototype.clonePrototype();
        //System.out.println(prototype == prototype1);

        System.out.println("原："+prototype.getBirthday());
        System.out.println("克隆后:"+prototype1.getBirthday());

        //修改
        prototype.setBirthday(new Date(1530584089));
        prototype.setName("李四");
        prototype.setAge(26);

        System.out.println("修改后原  名称："+prototype.getName()+"  年龄："+prototype.getAge()+" 生日："+prototype.getBirthday());
        System.out.println("修改后克隆 名称："+prototype1.getName()+"  年龄："+prototype1.getAge()+" 生日："+prototype1.getBirthday());

    }


    @Test
    public void testCloneCloneable() throws CloneNotSupportedException {
        UserPrototypeCloneable prototype = new UserPrototypeCloneable();
        prototype.setName("LIJUN");
        prototype.setAge(25);
        prototype.setBirthday(new Date(1520583326));
        prototype.setPhone(new Phone("IPHONE","RED"));
        UserPrototypeCloneable prototype1 = (UserPrototypeCloneable)prototype.clone();
        //System.out.println(prototype == prototype1);

        System.out.println("原："+prototype.getBirthday());
        System.out.println("克隆后:"+prototype1.getBirthday());

        System.out.println("修改前UserPrototypeCloneable对象："+(prototype==prototype1));
        System.out.println("修改前生日对象对象："+(prototype.getBirthday()==prototype1.getBirthday()));
        System.out.println("修改前Phone对象对象："+(prototype.getPhone()==prototype1.getPhone()));

        //修改
        prototype1.getBirthday().setDate(1530584089);
        prototype1.getPhone().setName("HUA WEI");


        System.out.println("修改后原  名称："+prototype.getName()+"  年龄："+prototype.getAge()+" 生日："+prototype.getBirthday()+" 手机："+prototype.getPhone());
        System.out.println("修改后克隆 名称："+prototype1.getName()+"  年龄："+prototype1.getAge()+" 生日："+prototype1.getBirthday()+" 手机："+prototype1.getPhone());
        System.out.println("修改后生日对象对象："+(prototype.getBirthday()==prototype1.getBirthday()));
    }


    @Test
    public void testCloneCloneableDeep() {
        UserPrototypeCloneableDeep prototype = new UserPrototypeCloneableDeep();
        prototype.setName("LIJUN");
        prototype.setAge(25);
        prototype.setBirthday(new Date(1520583326));
        prototype.setPhone(new Phone("IPHONE","RED"));
        UserPrototypeCloneableDeep prototype1 = (UserPrototypeCloneableDeep)prototype.clone();
        //System.out.println(prototype == prototype1);

        System.out.println("原："+prototype.getBirthday());
        System.out.println("克隆后:"+prototype1.getBirthday());

        System.out.println("修改前UserPrototypeCloneable对象："+(prototype==prototype1));
        System.out.println("修改前生日对象对象："+(prototype.getBirthday()==prototype1.getBirthday()));
        System.out.println("修改前Phone对象对象："+(prototype.getPhone()==prototype1.getPhone()));

        //修改
        prototype1.getBirthday().setDate(1530584089);
        prototype1.getPhone().setName("HUA WEI");

        System.out.println("修改后原  名称："+prototype.getName()+"  年龄："+prototype.getAge()+" 生日："+prototype.getBirthday()+" 手机："+prototype.getPhone());
        System.out.println("修改后克隆 名称："+prototype1.getName()+"  年龄："+prototype1.getAge()+" 生日："+prototype1.getBirthday()+" 手机："+prototype1.getPhone());
        System.out.println("修改后生日对象对象："+(prototype.getBirthday()==prototype1.getBirthday()));
    }

}