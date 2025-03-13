package com.article.sys.controller;

import com.article.sys.bean.Product;
import com.article.sys.service.IProductService;
import com.article.sys.util.LayuiData;
import com.article.sys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    IProductService productService;

    @RequestMapping("list")
    @ResponseBody
    public LayuiData getList(Page page, String text) {
        List<Product> list = productService.getList(page, text);
        int count = productService.getCount(text);
        return new LayuiData(count, list);
    }

    @RequestMapping("delete")
    @ResponseBody
    public int delete(int id){
        return productService.delete(id);
    }

    @RequestMapping("add")
    @ResponseBody
    public int add(Product product){
        return productService.add(product);
    }

    @RequestMapping("edit")
    @ResponseBody
    public int edit(Product product){
        return productService.edit(product);
    }

    @RequestMapping("someproduct")
    @ResponseBody
    public List<Product> someproduct(int limit ){
        return productService.getProducts(limit);
    }
    // In ProductController.java
    @RequestMapping("trending")
    @ResponseBody
    public LayuiData getTrendingProducts(@RequestParam("page") int pageNum, @RequestParam("limit") int limit) {
        Page page = new Page();
        page.setPage(pageNum);
        page.setLimit(limit);
        List<Product> list = productService.getTrendingProducts(page);
        int count = productService.getTrendingCount();
        System.out.println("Trending products: " + list + ", Count: " + count);
        return new LayuiData( count,list);
    }


    @RequestMapping("grids")
    @ResponseBody
    public LayuiData getProductsByCategory(@RequestParam("categoryid") int categoryid,
                                           @RequestParam(value = "page", defaultValue = "1") int pageNum,
                                           @RequestParam(value = "limit", defaultValue = "10") int limit) {
        Page page = new Page();
        page.setPage(pageNum <= 0 ? 1 : pageNum);
        page.setLimit(limit <= 0 ? 10 : limit);
        page.setStart((page.getPage() - 1) * page.getLimit());

        List<Product> products = productService.getProductsByCategory(categoryid, page);
        int count = productService.getProductCountByCategory(categoryid);

        System.out.println("Category ID: " + categoryid + ", Products: " + products + ", Count: " + count);
        return new LayuiData(count, products);
    }


    @RequestMapping("carouselProducts")
    @ResponseBody
    public List<Product> getCarouselProducts() {
        return productService.getProducts(5); // 复用已有的 getProducts 方法，限制返回 5 条
    }
}
