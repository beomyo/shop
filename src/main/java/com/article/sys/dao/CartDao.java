package com.article.sys.dao;

import com.article.sys.bean.Cart;
import com.article.sys.bean.CartProductList;
import com.article.sys.bean.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface CartDao {
    int addToCart(@Param("productid") int productid, @Param("addprice") BigDecimal addprice, @Param("userid") Integer userid);

    CartProductList GetCartProductList(@Param("userid") Integer userid);

    //购物车内的增减删
    int addInCart(@Param("productid") Integer productid);

    int cutInCart(@Param("productid") Integer productid);

    int deleteInCart(@Param("productid") Integer productid);

    int updateQuantity(@Param("productid") Integer productid, @Param("quantity") Integer quantity, @Param("userid") Integer userid);

    int selectInCart(@Param("productid") Integer productid, @Param("userid") Integer userid, @Param("flag") Integer flag);
    List<Cart> getSelectedItemsByUserId(@Param("userid") Integer userid);
    List<Map<String, Object>> getSelectedItemsWithProductDetails(@Param("userid") Integer userid);
    // 新增方法：根据用户ID和商品ID删除购物车记录
    int deleteInCartByUserIdAndProductId(@Param("userid") Integer userid, @Param("productid") Integer productid);
}
