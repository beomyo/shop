package com.article.sys.bean;

import java.io.Serializable;

public class OrderInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer orderid;      // 订单ID
    private Integer productid;    // 商品ID
    private Integer number;       // 商品数量
    private Double price;         // 购买时单价
    private String procductname;  // 购买时商品名称
    private String imgurl;        // 购买时商品图片

    // Getters and Setters
    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getProcductname() {
        return procductname;
    }

    public void setProcductname(String procductname) {
        this.procductname = procductname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderid=" + orderid +
                ", productid=" + productid +
                ", number=" + number +
                ", price=" + price +
                ", procductname='" + procductname + '\'' +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}