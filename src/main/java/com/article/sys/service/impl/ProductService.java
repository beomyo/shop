package com.article.sys.service.impl;

import com.article.sys.bean.Product;
import com.article.sys.dao.ProductDao;
import com.article.sys.service.IProductService;
import com.article.sys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    ProductDao productDao;

    @Override
    public int add(Product product) {
        return productDao.add(product);
    }

    @Override
    public int delete(int id) {
        return productDao.delete(id);
    }

    @Override
    public int edit(Product product) {
        return productDao.edit(product);
    }

    @Override
    public Product getByID(int id) {
        return productDao.getByID(id);
    }

    @Override
    public List<Product> getList(Page page, String text) {
        return productDao.getList(page, text);
    }


    @Override
    public int getCount(String text) {
        return productDao.getCount(text);
    }
    @Override
    public List<Product> getProducts(int limit) {
        return productDao.getProducts(limit);
    }

    @Override
    public List<Product> getTrendingProducts(Page page) {
        return productDao.getTrendingProducts(page);
    }

    @Override
    public int getTrendingCount() {
        return productDao.getTrendingCount();
    }
    @Override
    public List<Product> getProductsByCategory(int categoryid, Page page) {
        return productDao.getProductsByCategory(categoryid, page);
    }

    @Override
    public int getProductCountByCategory(int categoryid) {
        return productDao.getProductCountByCategory(categoryid);
    }

}
