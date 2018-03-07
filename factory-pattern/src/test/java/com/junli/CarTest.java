package com.junli;

import com.junli.abstr.car.*;
import com.junli.func.car.BmCarFuncFactory;
import com.junli.func.car.CarFuncFactory;
import com.junli.simple.car.CarSimpleFactory;
import org.junit.Test;

/**
 * @author lijun
 * @since 2018-03-05 14:48
 */
public class CarTest {

    /**
     * 无工厂
     */
    @Test
    public void createCar() {
      Car car = new BmCar();
      car.getName();
    }

    /**
     * 简单工厂
     * @throws Exception
     */
    @Test
    public void  createCarBySimpleFactory() throws Exception {
        Car car = CarSimpleFactory.getCar("bm");
        car.getName();
    }

    /**
     * 工厂方法模式
     */
    @Test
    public void  createCarByFuncFactory(){
        CarFuncFactory funcFactory = new BmCarFuncFactory();
        System.out.println(funcFactory.showName());

    }

    /**
     * 抽象工厂
     */
    @Test
    public  void createCarAbstrFactory(){
        AbstractFactory carFactory = new CarFactory();
        carFactory.getBenzCar().getName();
        carFactory.getBmCar().getName();
    }

    /**
     * 引入工厂师角色的抽象工厂
     */
    @Test
    public  void createCarAbstrFactoryRef() throws Exception {
        CarEngineer carEngineer = new CarEngineer();
        AbstractFactory abstractFactory = new CarFactory();
        carEngineer.makeCar(abstractFactory);
    }
    /**
     * 扩展抽象工厂
     */
    @Test
    public  void createCarAbstrFactoryExtra() throws Exception {
        CarEngineerExtra carEngineer = new CarEngineerExtra();
        AbstractFactoryExtra abstractFactoryExtra = new CarFactoryExtra();
        carEngineer.makeCar(abstractFactoryExtra);
    }
}