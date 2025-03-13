package com.article.sys.dao;

import com.article.sys.bean.Category;
import com.article.sys.util.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CategoryDao {
    //起别名,必须通过别名调用
    int add(@Param("category") Category category);

    int delete(@Param("id")int id);

    int edit(@Param("category")Category category);

    Category getByID(@Param("id")int id);

    List<Category> getList(@Param("page")Page page, @Param("text")String text);

    List<Category> getChildren(@Param("id")int id);

    int getCount(@Param("text")String text);
    List<Category> getOneTwo(@Param("pid") Integer pid);


    List<Category> getAllCategories();
}
