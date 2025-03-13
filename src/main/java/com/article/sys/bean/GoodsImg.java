package com.article.sys.bean;

import java.io.Serializable;

public class GoodsImg implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer productid; // 商品ID
    private String imgurl;     // 图片地址

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    @Override
    public String toString() {
        return "GoodsImg{" +
                "id=" + id +
                ", productid=" + productid +
                ", imgurl='" + imgurl + '\'' +
                '}';
    }
}