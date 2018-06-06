package com.springboot.start.bean;

import com.mysql.jdbc.StringUtils;

import javax.persistence.*;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Entity
@Table(name = "wash_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // FM设定
    private String client_id;

    // FM设定
    private String station_aliais;

    // Client设定，唯一
    private String out_trade_no;

    // 1,2,3 （1是不吹风，2是洗车+吹风 ， 3是预洗+模式2）
    private int service_mode;

    // unix时间
    private long time;

    // 维度
    private String lati;

    // 经度
    private String longitude;

    // 优惠券唯一码， 有则标识优惠券消费
    private String coupon_unique;

    private boolean use_coupon;

    // 订单交易金额
    private double price;

    // 交易用户(email或phone)
    private String user_name;

    // 支付成功
    private boolean payment_success;

    private String phone;

    public Order() {
    }

    public Order(Payment payment) {
        this.client_id = payment.client_id;
        if (StringUtils.isNullOrEmpty(payment.unideCodes)) {
            this.coupon_unique = payment.unideCodes;
            this.use_coupon = true;
        } else {
            this.use_coupon = false;
        }
        this.user_name = payment.phone;
        this.price = payment.price;
    }

    public void setPayment_success(boolean payment_success) {
        this.payment_success = payment_success;
    }
}
