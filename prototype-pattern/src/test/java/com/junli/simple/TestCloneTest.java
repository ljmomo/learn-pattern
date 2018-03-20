package com.junli.simple;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author lijun
 * @since 2018-03-10 22:47
 */
public class TestCloneTest {

    @Test
    public void testClone() throws CloneNotSupportedException {
        TestClone testClone = new TestClone();
        testClone.setAge(1);
        testClone.setName("Name");

        ArrayList arrayList = new ArrayList();
        arrayList.add("12");
        testClone.setMyList(arrayList);
        TestClone clone = (TestClone)testClone.clone();

        System.out.println("克隆后和克隆前的对象对比："+(clone==testClone));

        System.out.println("克隆后和克隆前ArrayList对象对比："+(clone.getMyList()==testClone.getMyList()));

        clone.getMyList().add("222");
        System.out.println("克隆对象ArrayList添加一个值："+clone.getMyList());

        System.out.println("被克隆对象ArrayList："+testClone.getMyList());

    }
}