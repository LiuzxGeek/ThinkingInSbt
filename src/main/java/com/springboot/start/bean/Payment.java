package com.springboot.start.bean;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
public class Payment {
    /**
     * 支付金额
     */
    public double price;

    /**
     * 支付使用优惠券
     */
    public String unideCodes;

    /**
     * 支付设备id
     */
    public String client_id;

    /**
     * 设备电话号码
     */
    public String phone;
}
