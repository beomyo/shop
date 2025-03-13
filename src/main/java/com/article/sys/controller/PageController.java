package com.article.sys.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {
//    @RequestMapping("upload")
//    public String upload() {
//        return "upload.html";
//    }
    @RequestMapping("category")
    public String category() {
        return "category.html";
    }

    @RequestMapping("product")
    public String product() {
        return "product.html";
    }
    @RequestMapping("userinfo")
    public String userinfo() {
        return "system/userinfo.html";
    }
    @RequestMapping("admin")
    public String admin() {
        return "admin.html";
    }
    @RequestMapping("order") // 新增
    public String order() {
        return "order.html";
    }
    @RequestMapping("orderinfo")
    public String orderinfo() {
        return "system/userpage/orderinfo.html";
    }
    @RequestMapping("passwordinfo")
    public String passwordinfo() {
        return "system/userpage/passwordinfo.html";
    }
    @RequestMapping("basicinfo")
    public String basicinfo() {
        return "system/userpage/basicinfo.html";
    }
    @RequestMapping("addressinfo")
    public String addressinfo() {
        return "system/userpage/addressinfo.html";
    }


}


