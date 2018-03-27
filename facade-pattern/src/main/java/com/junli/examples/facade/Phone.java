package com.junli.examples.facade;

import com.junli.examples.children.CPU;
import com.junli.examples.children.Memory;
import com.junli.examples.children.ROM;

/**
 * @author lijun
 * @since 2018-03-27 17:04
 */
public class Phone {
    /**
     * cpu
     */
    private CPU cpu = null;

    /**
     * memory
     */
    private Memory memory = null;

    /**
     * rom
     */
    private ROM rom = null;

    public Phone() {
        cpu = new CPU();
        memory = new Memory();
        rom = new ROM();
    }

    /**
     * start
     */
    public void  start(){
        cpu.start();
        memory.start();
        rom.start();
    }

    /**
     * 关闭
     */
    public void  shutDwon(){
        cpu.shutDown();
        memory.shutDown();
        rom.shutDown();
    }

}
