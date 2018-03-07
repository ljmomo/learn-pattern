package com.junli.abstr.car;

import com.junli.Car;

/**
 * @author lijun
 * @since 2018-03-07 10:57
 */
public interface AbstractFactoryExtra {
    /**
     * 获得车
     * @param type
     * @return
     */
    public Car getCar(int type) throws Exception;
}
