package com.article.sys.service.impl;

import com.article.sys.bean.Cart;
import com.article.sys.bean.CartProductList;
import com.article.sys.bean.Product;
import com.article.sys.dao.CartDao;
import com.article.sys.dao.CategoryDao;
import com.article.sys.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class CartService implements ICartService {
    @Autowired
    CartDao cartDao;

    @Override//添加商品到购物车
    public int addToCart(int productid, BigDecimal addprice, Integer userid) {
        return cartDao.addToCart(productid, addprice, userid);
    }

    @Override
    public CartProductList GetCartProductList(Integer userid) {
        return cartDao.GetCartProductList(userid);
    }

    @Override
    public int addInCart(Integer productid) {
        return cartDao.addInCart(productid);
    }

    @Override
    public int cutInCart(Integer productid) {
        return cartDao.cutInCart(productid);
    }

    @Override
    public int deleteInCart(Integer productid) {
        return cartDao.deleteInCart(productid);
    }

    @Override
    public int selectInCart(Integer productid, Integer userid, Integer flag) {
        return cartDao.selectInCart(productid, userid, flag);
    }

    @Override
    public int updateQuantity(Integer productid, Integer quantity, Integer userid) {
        return cartDao.updateQuantity(productid, quantity, userid);
    }

    @Override
    public List<Cart> getSelectedItemsByUserId(Integer userId) {
        return cartDao.getSelectedItemsByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> getSelectedItemsWithProductDetails(Integer userId) {
        return cartDao.getSelectedItemsWithProductDetails(userId);
    }
    // 新增实现：根据用户ID和商品ID删除购物车记录
    @Override
    public int deleteInCartByUserIdAndProductId(Integer userid, Integer productid) {
        return cartDao.deleteInCartByUserIdAndProductId(userid, productid);
    }
}
