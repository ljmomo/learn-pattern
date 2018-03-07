package com.junli.abstr.car;

import com.junli.BenzCar;
import com.junli.BlCar;
import com.junli.BmCar;

/**
 * 制造工厂师
 * @author lijun
 * @since 2018-03-07 11:07
 */
public class CarEngineerExtra {
    /**
     *宝马
     */
    private BmCar bmCar =null;

    /**
     *奔驰
     */
    private BenzCar benzCar = null;

    /**
     *奔驰
     */
    private BlCar blCar = null;

    public void makeCar(AbstractFactoryExtra abstractFactoryExtra) throws Exception {

        //获取宝马Car
        this.bmCar = (BmCar) abstractFactoryExtra.getCar(1);

        //获取奔驰Car
        this.benzCar = (BenzCar) abstractFactoryExtra.getCar(2);

        //获取宾利Car
        this.blCar = (BlCar) abstractFactoryExtra.getCar(3);
    }

}
