package com.springboot.start.bean;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // 别名
    private String nickName;

    // 头像
    private String avatarUrl;

    // 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private String gender;

    // 用户所在城市
    private String city;

    // 用户所在省份
    private String province;

    // 用户所在国家
    private String country;

    // 用户的语言，简体中文为zh_CN
    private String language;

    // 电话号码
    private String phone;

    // 邮箱
    private String email;

    public void setId(long id) {
        this.id = id;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getGender() {
        return gender;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getCountry() {
        return country;
    }

    public String getLanguage() {
        return language;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}
