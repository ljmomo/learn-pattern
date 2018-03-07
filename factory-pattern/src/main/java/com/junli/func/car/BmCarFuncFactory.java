package com.junli.func.car;

import com.junli.BmCar;
import com.junli.Car;

/**
 * @author lijun
 * @since 2018-03-06 11:11
 */
public class BmCarFuncFactory extends CarFuncFactory {
    /**
     * 获取
     *
     * @return car
     */
    @Override
    public Car getCar() {
        return new BmCar();
    }
}
