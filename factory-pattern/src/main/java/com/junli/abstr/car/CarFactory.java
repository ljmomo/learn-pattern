package com.junli.abstr.car;

import com.junli.BenzCar;
import com.junli.BmCar;

/**
 * @author lijun
 * @since 2018-03-06 17:26
 */
public class CarFactory implements AbstractFactory {
    /**
     * 获取宝马对象
     *
     * @return
     */
    @Override
    public BmCar getBmCar() {
        return new BmCar();
    }

    /**
     * 获取奔驰对象
     *
     * @return
     */
    @Override
    public BenzCar getBenzCar() {
        return new BenzCar();
    }
}
