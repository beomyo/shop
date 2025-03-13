package com.article.sys.bean;

import java.io.Serializable;
import java.math.BigDecimal;

public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userid;    // 用户ID
    private Integer productid; // 商品ID
    private Integer number;    // 商品数量
    private BigDecimal addprice;   // 加购物车时的价格
    private Integer selected;  // Add this field

    public Integer getSelected() {
        return selected;
    }

    public void setSelected(Integer selected) {
        this.selected = selected;
    }
    // Getters and Setters
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public BigDecimal getAddprice() {
        return addprice;
    }

    public void setAddprice(BigDecimal addprice) {
        this.addprice = addprice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "userid=" + userid +
                ", productid=" + productid +
                ", number=" + number +
                ", addprice=" + addprice +
                '}';
    }
}