package com.junli.simple.car;

import com.junli.BenzCar;
import com.junli.BmCar;
import com.junli.Car;

/**
 * @author lijun
 * @since 2018-03-05 15:39
 */
public class CarSimpleFactory {

    private CarSimpleFactory() {
    }

    public static Car getCar(String name) throws Exception{
        Car car = null;
        if ("bm".equals(name)){
            car = new BmCar();
        }else if ("bc".equals(name)){
            car = new BenzCar();
        }else{
            throw new Exception("找不到要创建的Car");
        }
        return car;
    }
}
