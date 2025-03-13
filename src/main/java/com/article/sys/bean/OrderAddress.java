package com.article.sys.bean;

import java.io.Serializable;

public class OrderAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer orderid;      // 订单ID
    private String address;       // 收货地址
    private String name;          // 收货人姓名
    private String tel;           // 收货人电话

    // Getters and Setters
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "OrderAddress{" +
                "orderid=" + orderid +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
