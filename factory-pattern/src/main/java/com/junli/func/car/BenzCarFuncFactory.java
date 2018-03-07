package com.junli.func.car;

import com.junli.BenzCar;
import com.junli.Car;

/**
 * @author lijun
 * @since 2018-03-06 11:11
 */
public class BenzCarFuncFactory extends CarFuncFactory {
    /**
     * 获取
     *
     * @return car
     */
    @Override
    public Car getCar() {
        return new BenzCar();
    }
}
