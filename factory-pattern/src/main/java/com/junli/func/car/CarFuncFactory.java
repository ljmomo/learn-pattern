package com.junli.func.car;

import com.junli.Car;

/**
 * @author lijun
 * @since 2018-03-06 11:03
 */
public abstract class CarFuncFactory {

    /**
     * 获取
     * @return car
     */
    protected abstract Car getCar();

    public String showName(){
        Car car = getCar();
        return car.getName();
    }
}