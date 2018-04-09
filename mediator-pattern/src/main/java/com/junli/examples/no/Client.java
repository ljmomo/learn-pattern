package com.junli.examples.no;

/**
 * @author lijun
 * @since 2018-04-09 9:37
 */
public class Client {
    public static void main(String[] args){    
    
        AbstractColleague collA = new ConcreteColleagueA();
        AbstractColleague collB = new ConcreteColleagueB();
            
        System.out.println("==========设置A影响B==========");    
        collA.setNumber(1288, collB);    
        System.out.println("collA的number值："+collA.getNumber());    
        System.out.println("collB的number值："+collB.getNumber());    
    
        System.out.println("==========设置B影响A==========");    
        collB.setNumber(87635, collA);    
        System.out.println("collB的number值："+collB.getNumber());    
        System.out.println("collA的number值："+collA.getNumber());    
    }    
}    