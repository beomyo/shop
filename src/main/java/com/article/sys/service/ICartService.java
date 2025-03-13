package com.article.sys.service;

import com.article.sys.bean.Cart;
import com.article.sys.bean.CartProductList;
import com.article.sys.bean.Product;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface ICartService {
    int addToCart(int productid, BigDecimal addprice, Integer userid);

    CartProductList GetCartProductList(Integer userid);

    int addInCart(Integer productid);

    int cutInCart(Integer productid);

    int deleteInCart(Integer productid);

    int updateQuantity(Integer productid, Integer quantity, Integer userid);

    int selectInCart(Integer productid, Integer userid, Integer flag);
    List<Cart> getSelectedItemsByUserId(Integer userId);
    List<Map<String, Object>> getSelectedItemsWithProductDetails(Integer userId);
    // 新增方法：根据用户ID和商品ID删除购物车记录
    int deleteInCartByUserIdAndProductId(@Param("userid") Integer userid, @Param("productid") Integer productid);
}
