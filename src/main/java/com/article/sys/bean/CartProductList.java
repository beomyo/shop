package com.article.sys.bean;

import java.util.List;

public class CartProductList {
    List<Product> productList;
    Integer productcategorycount;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Integer getCount() {
        return productcategorycount;
    }

    public void setCount(Integer count) {
        this.productcategorycount = count;
    }
}
