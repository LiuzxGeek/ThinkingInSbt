package com.springboot.start.bean;

import javax.persistence.*;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 隶属于那个用户
    private long user_id;

    // 面值
    private Double price;

    // 唯一码
    private String uniqueCode;

    // 优惠券类型（折扣discount，抵用purpose）
    private String type;

    // 最低使用额度
    private double lowest;

    // 是否已经使用过
    private boolean used;

}
