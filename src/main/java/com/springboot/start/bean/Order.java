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
    private long occur_time;

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

    public void setId(long id) {
        this.id = id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public void setStation_aliais(String station_aliais) {
        this.station_aliais = station_aliais;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public void setService_mode(int service_mode) {
        this.service_mode = service_mode;
    }

    public void setTime(long time) {
        this.occur_time = time;
    }

    public void setLati(String lati) {
        this.lati = lati;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setCoupon_unique(String coupon_unique) {
        this.coupon_unique = coupon_unique;
    }

    public void setUse_coupon(boolean use_coupon) {
        this.use_coupon = use_coupon;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public String getClient_id() {
        return client_id;
    }

    public String getStation_aliais() {
        return station_aliais;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public int getService_mode() {
        return service_mode;
    }

    public long getTime() {
        return occur_time;
    }

    public String getLati() {
        return lati;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCoupon_unique() {
        return coupon_unique;
    }

    public boolean isUse_coupon() {
        return use_coupon;
    }

    public double getPrice() {
        return price;
    }

    public String getUser_name() {
        return user_name;
    }

    public boolean isPayment_success() {
        return payment_success;
    }

    public String getPhone() {
        return phone;
    }

    public void setPayment_success(boolean payment_success) {
        this.payment_success = payment_success;
    }
}
