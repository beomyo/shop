package com.article.sys.controller;

import com.article.sys.bean.Category;
import com.article.sys.service.ICategoryService;
import com.article.sys.service.IProductService;
import com.article.sys.util.LayuiData;
import com.article.sys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("category")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @Autowired
    IProductService productService;
    @RequestMapping("list")
    @ResponseBody
    public LayuiData getList(Page page, String text) {
        List<Category> list = categoryService.getList(page, text);
        int count = categoryService.getCount(text);
        return new LayuiData(count, list);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(int id) {
        return categoryService.delete(id);
    }

    @RequestMapping("getchildren")
    @ResponseBody
    public List<Category> getChildren(int id) {
        return categoryService.getChildren(id);
    }

    @RequestMapping("add")
    @ResponseBody
    public int add(Category category) {
        return categoryService.add(category);
    }


    @RequestMapping("edit")
    @ResponseBody
    public int edit(Category category) {
        return categoryService.edit(category);
    }
    @RequestMapping("getonetwo")
    @ResponseBody
    List<Category> getOneTwo(  Integer pid){
        return categoryService.getOneTwo(pid);
    }
    // In CategoryController.java
    @RequestMapping("allWithProductCount")
    @ResponseBody
    public List<Map<String, Object>> getAllCategoriesWithProductCount() {
        List<Category> categories = categoryService.getAllCategories(); // Fetch all categories
        List<Map<String, Object>> result = new ArrayList<>();

        for (Category category : categories) {
            int productCount = productService.getProductCountByCategory(category.getId()); // Get product count
            Map<String, Object> categoryData = new HashMap<>();
            categoryData.put("id", category.getId());
            categoryData.put("name", category.getName());
            categoryData.put("productCount", productCount);
            result.add(categoryData);
        }

        return result;
    }

}
