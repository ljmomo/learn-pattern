package com.junli.abstr.car;

import com.junli.BenzCar;
import com.junli.BlCar;
import com.junli.BmCar;
import com.junli.Car;

/**
 * @author lijun
 * @since 2018-03-07 11:01
 */
public class CarFactoryExtra implements AbstractFactoryExtra{
    /**
     * 获得车
     *
     * @param type
     * @return
     */
    @Override
    public Car getCar(int type) throws Exception {
        Car car = null;
        if (type == 1) {
            car = new BmCar();
        } else if (type == 2) {
            car = new BenzCar();
        } else if (type == 3) {
            car = new BlCar();
        }else {
            throw new Exception("找不到！");
        }
        return car;
    }
}
