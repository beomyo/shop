package com.article.sys.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String code;          // 订单编号
    private Integer userid;       // 用户ID
    private Double money;         // 订单金额
    private LocalDateTime addtime;         // 下单时间
    private LocalDateTime paymenttime;     // 付款时间
    private LocalDateTime deliverytime;    // 发货时间
    private LocalDateTime receivetime;         // 收货时间
    private LocalDateTime endtime;         // 订单结束时间
    private Integer state;        // 订单状态（0-未支付；1-已付款未发货；2-已发货未收货；3-已收货；4-已完成）
    private LocalDateTime updatetime;      // 订单最近更新时间
//    List<OrderInfo> infos;
//    OrderAddress address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public LocalDateTime getAddtime() {
        return addtime;
    }

    public void setAddtime(LocalDateTime addtime) {
        this.addtime = addtime;
    }

    public LocalDateTime getPaymenttime() {
        return paymenttime;
    }

    public void setPaymenttime(LocalDateTime paymenttime) {
        this.paymenttime = paymenttime;
    }

    public LocalDateTime getDeliverytime() {
        return deliverytime;
    }

    public void setDeliverytime(LocalDateTime deliverytime) {
        this.deliverytime = deliverytime;
    }

    public LocalDateTime getReceivetime() {
        return receivetime;
    }

    public void setReceivetime(LocalDateTime receivetime) {
        this.receivetime = receivetime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }
}