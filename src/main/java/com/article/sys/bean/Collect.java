package com.article.sys.bean;

import java.io.Serializable;
import java.util.Date;

public class Collect implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userid;    // 用户ID
    private Integer productid; // 商品ID
    private Date collecttime;  // 收藏时间

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

    public Date getCollecttime() {
        return collecttime;
    }

    public void setCollecttime(Date collecttime) {
        this.collecttime = collecttime;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "userid=" + userid +
                ", productid=" + productid +
                ", collecttime=" + collecttime +
                '}';
    }
}