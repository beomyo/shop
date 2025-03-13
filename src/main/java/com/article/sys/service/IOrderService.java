package com.article.sys.service;

import com.article.sys.bean.Order;
import com.article.sys.bean.OrderAddress;
import com.article.sys.bean.OrderInfo;

import java.util.List;

public interface IOrderService {
    void addOrder(Order order);
    void addOrderAddress(OrderAddress orderAddress);
    void addOrderInfo(OrderInfo orderInfo);
    Order getOrderById(Integer id);
    void updateOrder(Order order);
    List<OrderInfo> getOrderInfosByOrderId(Integer orderId);
    // 新增方法
    List<Order> getOrdersByUserId(Integer userId, int start, int limit);
    int getOrderCountByUserId(Integer userId);
    OrderAddress getOrderAddressByOrderId(Integer orderId);
    List<Order> getAllOrders(int start, int limit);
    int getAllOrdersCount();

    void cancleOrder();

    Order getOrderByCode(String outTradeNo);
}