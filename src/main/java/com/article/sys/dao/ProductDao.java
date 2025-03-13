package com.article.sys.dao;

import com.article.sys.bean.Category;
import com.article.sys.bean.Product;
import com.article.sys.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductDao {
    //起别名,必须通过别名调用
    int add(@Param("product") Product product);

    int delete(@Param("id") int id);

    int edit(@Param("product") Product product);

    Product getByID(@Param("id") int id);

    List<Product> getList(@Param("page") Page page, @Param("text") String text);

    int getCount(@Param("text") String text);

    List<Product> getProducts(int limit);

    List<Product> getTrendingProducts(@Param("page") Page page);
    int getTrendingCount();
    List<Product> getProductsByCategory(@Param("categoryid") int categoryid, @Param("page") Page page);
    int getProductCountByCategory(@Param("categoryid") int categoryid);
}
