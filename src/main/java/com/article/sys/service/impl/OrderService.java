package com.article.sys.service.impl;

import com.article.sys.bean.Order;
import com.article.sys.bean.OrderAddress;
import com.article.sys.bean.OrderInfo;
import com.article.sys.dao.OrderDao;
import com.article.sys.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        orderDao.addOrder(order);
    }

    @Override
    public void addOrderAddress(OrderAddress orderAddress) {
        orderDao.addOrderAddress(orderAddress);
    }

    @Override
    public void addOrderInfo(OrderInfo orderInfo) {
        orderDao.addOrderInfo(orderInfo);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }
    @Override
    public List<OrderInfo> getOrderInfosByOrderId(Integer orderId) {
        return orderDao.getOrderInfosByOrderId(orderId);
    }
    @Override
    public List<Order> getOrdersByUserId(Integer userId, int start, int limit) {
        return orderDao.getOrdersByUserId(userId, start, limit); // 需新增DAO方法
    }

    @Override
    public int getOrderCountByUserId(Integer userId) {
        return orderDao.getOrderCountByUserId(userId); // 需新增DAO方法
    }

    @Override
    public OrderAddress getOrderAddressByOrderId(Integer orderId) {
        return orderDao.getOrderAddressByOrderId(orderId); // 需新增DAO方法
    }
    @Override
    public List<Order> getAllOrders(int start, int limit) {
        return orderDao.getAllOrders(start, limit); // 新增DAO方法
    }

    @Override
    public int getAllOrdersCount() {
        return orderDao.getAllOrdersCount(); // 新增DAO方法
    }

    @Override
    public void cancleOrder() {
        orderDao.cancleOrder();
    }

    @Override
    public Order getOrderByCode(String outTradeNo) {
        return orderDao.getOrderByCode(outTradeNo);
    }
}