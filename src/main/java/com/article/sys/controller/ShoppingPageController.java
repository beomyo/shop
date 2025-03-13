package com.article.sys.controller;

import com.article.sys.bean.Product;
import com.article.sys.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("shopping")
public class ShoppingPageController {

    @Autowired
    private IProductService productService;

    @RequestMapping("index")
    public String index() {
        return "system/index.html";
    }

    @RequestMapping("details")
    public String details(@RequestParam("id") int id, Model model) {
        Product product = productService.getByID(id);
        if (product == null) {
            // 可以考虑返回错误页面或重定向
            return "redirect:/shopping/index";
        }
        model.addAttribute("product", product);
        return "system/product-details.html";
    }

    // 其他现有方法保持不变
    @RequestMapping("grids")
    public String grids() {
        return "system/product-grids.html";
    }

    @RequestMapping("login")
    public String login() {
        return "system/login.html";
    }

    @RequestMapping("register")
    public String register() {
        return "system/register.html";
    }

    @RequestMapping("cart")
    public String cart() {
        return "system/cart.html";
    }

    @RequestMapping("checkout")
    public String checkout() {
        return "system/checkout.html";
    }

    @RequestMapping("list")
    public String list() {
        return "system/product-list.html";
    }
    @RequestMapping("payment")
    public String payment() {
        return "system/payment.html";
    }
}