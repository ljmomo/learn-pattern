package com.junli.examples.no;
/**
 * @author lijun
 * @since 2018-04-09 9:37
 */
public class ConcreteColleagueA extends AbstractColleague{
    @Override
    public void setNumber(int number, AbstractColleague coll) {
        this.number = number;    
        coll.setNumber(number*100);    
    }    
}    