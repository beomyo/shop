package com.article.sys.service.impl;

import com.article.sys.bean.Category;
import com.article.sys.dao.CategoryDao;
import com.article.sys.service.ICategoryService;
import com.article.sys.util.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryDao categoryDao;


    @Override
    public int add(Category category) {
        return categoryDao.add(category);
    }

    @Override
    public int delete(int id) {
        return categoryDao.delete(id);
    }

    @Override
    public int edit(Category category) {
        return categoryDao.edit(category);
    }

    @Override
    public Category getByID(int id) {
        return categoryDao.getByID(id);
    }

    @Override
    public List<Category> getList(Page page, String text) {
        return categoryDao.getList(page, text);
    }

    @Override
    public List<Category> getChildren(int id) {
        return categoryDao.getChildren(id);
    }

    @Override
    public int getCount(String text) {
        return categoryDao.getCount(text);
    }
    @Override
    public List<Category> getOneTwo(Integer pid){
        return categoryDao.getOneTwo(pid);
    }
    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }
}
