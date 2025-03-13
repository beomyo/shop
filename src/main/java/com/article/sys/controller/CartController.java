package com.article.sys.controller;

import com.article.sys.bean.CartProductList;
import com.article.sys.bean.Product;
import com.article.sys.bean.User;
import com.article.sys.service.ICartService;
import com.article.sys.util.SYS;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;


@Controller
@RequestMapping("cart")
public class CartController {
    @Autowired
    ICartService cartService;


    @RequestMapping("addtocart")
    @ResponseBody
    public int addToCart(int productid, BigDecimal addprice,HttpSession session){
        User u=(User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        Integer userid=u.getId();
        if (userid!=null){
            return cartService.addToCart(productid,addprice,userid);
        }else return 0;

    }
    @RequestMapping("getcartproductlist")
    @ResponseBody
    public CartProductList GetCartProductList(HttpSession session){
        User u=(User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        Integer userid=u.getId();
        return cartService.GetCartProductList(userid);
    }

    @RequestMapping("add")
    @ResponseBody
    public int add(Integer productid){

        return cartService.addInCart(productid);
    }
    @RequestMapping("cut")
    @ResponseBody
    public int cut(Integer productid){
        return cartService.cutInCart(productid);
    }
    @RequestMapping("delete")
    @ResponseBody
    public int delete(Integer productid){
        return cartService.deleteInCart(productid);
    }

    @RequestMapping("selected")
    @ResponseBody
    public int selected(Integer productid,HttpSession session,Integer flag){
        User u=(User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        Integer userid=u.getId();
        return cartService.selectInCart(productid,userid,flag);
    }


    @RequestMapping("updateQuantity")
    @ResponseBody
    public int updateQuantity(@RequestParam Integer productid, @RequestParam Integer quantity, HttpSession session) {
        User u = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (u == null) return 0;
        Integer userid = u.getId();
        return cartService.updateQuantity(productid, quantity, userid);
    }

}
