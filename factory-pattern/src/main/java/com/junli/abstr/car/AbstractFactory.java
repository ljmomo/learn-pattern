package com.junli.abstr.car;

import com.junli.BenzCar;
import com.junli.BmCar;

/**
 * @author lijun
 * @since 2018-03-06 17:24
 */
public interface AbstractFactory {
    /**
     * 获取宝马对象
     * @return Car
     */
    BmCar getBmCar();

    /**
     * 获取奔驰对象
     * @return Car
     */
    BenzCar getBenzCar();

}
