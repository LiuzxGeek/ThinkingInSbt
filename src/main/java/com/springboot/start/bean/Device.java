package com.springboot.start.bean;

import javax.persistence.*;

/**
 * @Author liuxian
 * @Date 2018/6/5
 * @Desc
 */
@Entity
@Table(name = "device")
public class Device {
    /**
     * 设备唯一ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;

    // 洗车机系统指定的，每个站点有一个固定的别名
    private String station_aliais;

    /**
     * 设备地址
     */
    private String addr;

    /**
     * 设备生产厂商
     */
    private String manufacturer;

    /**
     * 设备生产厂商
     */
    private String ip_addr;

    /**
     * 设备管理员用户
     */
    private long admin_id;

    /**
     * 设备拥有者
     */
    private long owner_id;
}
