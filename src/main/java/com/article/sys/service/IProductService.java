package com.article.sys.service;

import com.article.sys.bean.Category;
import com.article.sys.bean.Product;
import com.article.sys.util.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IProductService {
    int add(Product product);

    int delete(int id);

    int edit(Product product);

    Product getByID(int id);

    List<Product> getList(Page page, String text);

    int getCount(String text);

    List<Product> getProducts(int limit);

    List<Product> getTrendingProducts(Page page);
    int getTrendingCount();

    List<Product> getProductsByCategory(int categoryid, Page page);
    int getProductCountByCategory(int categoryid);

}
