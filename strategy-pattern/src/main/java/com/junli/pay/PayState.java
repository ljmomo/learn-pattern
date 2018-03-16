package com.junli.pay;

/**
 * 支付状态
 * @author lijun
 * @since 2018-03-16 13:56
 */
public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState(int code, String msg, Object data) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return ("支付状态：[" + code + "]," + msg + ",交易详情：" + data);
    }
}
