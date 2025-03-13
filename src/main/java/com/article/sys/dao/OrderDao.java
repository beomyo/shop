package com.article.sys.dao;

import com.article.sys.bean.Order;
import com.article.sys.bean.OrderAddress;
import com.article.sys.bean.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    void addOrder(Order order);
    void addOrderAddress(OrderAddress orderAddress);
    void addOrderInfo(OrderInfo orderInfo);
    Order getOrderById(Integer id);
    void updateOrder(Order order);
    List<OrderInfo> getOrderInfosByOrderId(@Param("orderId") Integer orderId);
    // 新增方法
    List<Order> getOrdersByUserId(@Param("userId") Integer userId, @Param("start") int start, @Param("limit") int limit);
    int getOrderCountByUserId(@Param("userId") Integer userId);
    OrderAddress getOrderAddressByOrderId(@Param("orderId") Integer orderId);
    List<Order> getAllOrders(@Param("start") int start, @Param("limit") int limit);
    int getAllOrdersCount();

    void cancleOrder();

    Order getOrderByCode(@Param("code") String outTradeNo);
}