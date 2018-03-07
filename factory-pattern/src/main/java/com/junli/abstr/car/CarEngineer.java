package com.junli.abstr.car;

import com.junli.BenzCar;
import com.junli.BmCar;

/**
 * @author lijun
 * @since 2018-03-07 13:13
 */
public class CarEngineer {
    /**
     *宝马
     */
    private BmCar bmCar =null;

    /**
     *奔驰
     */
    private BenzCar benzCar = null;

    public void makeCar(AbstractFactory abstractFactory) throws Exception {

        //获取宝马Car
        this.bmCar = abstractFactory.getBmCar();

        //获取奔驰Car
        this.benzCar =  abstractFactory.getBenzCar();

    }
}
