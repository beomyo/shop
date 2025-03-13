package com.article.sys.service;

import com.article.sys.bean.Category;
import com.article.sys.util.Page;

import java.util.List;

public interface ICategoryService {

    int add(Category category);

    int delete(int id);

    int edit(Category category);

    Category getByID(int id);

    List<Category> getList(Page page, String text);

    List<Category> getChildren(int id);

    int getCount(String text);
    List<Category> getOneTwo( Integer pid);

    List<Category> getAllCategories();
}
