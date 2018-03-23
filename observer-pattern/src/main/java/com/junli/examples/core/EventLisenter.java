package com.junli.examples.core;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 事件的注册和监听
 *
 * @author lijun
 * @since 2018-03-23 15:07
 */
public class EventLisenter {

    /**
     * Map相当于是一个注册器
     */
    protected Map<Enum, Event> events = new HashMap<Enum, Event>();

    /**
     * 注册事件
     *
     * @param eventType eventType
     * @param target    target
     * @param callback  callback
     */
    public void addLisenter(Enum eventType, Object target, Method callback) {
        //注册事件
        //用反射调用这个方法
        events.put(eventType, new Event(target, callback));
    }

    /**
     * 触发事件
     *
     * @param e
     */
    private void trigger(Event e) {
        e.setSource(this);
        e.setTime(System.currentTimeMillis());

        try {
            e.getCallback().invoke(e.getTarget(), e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }


    protected void trigger(Enum call) {
        if (!this.events.containsKey(call)) {
            return;
        }
        trigger(this.events.get(call).setTrigger(call.toString()));
    }

}
