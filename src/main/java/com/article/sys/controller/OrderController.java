package com.article.sys.controller;

import com.article.sys.bean.Order;
import com.article.sys.bean.OrderAddress;
import com.article.sys.bean.OrderInfo;
import com.article.sys.service.IOrderService;
import com.article.sys.util.LayuiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    // 查询用户的所有订单
    @GetMapping("getOrdersByUserId")
    @ResponseBody
    public LayuiData getOrdersByUserId(@RequestParam("userId") Integer userId,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "limit", defaultValue = "10") int limit) {
        // 这里需要实现分页查询逻辑，假设OrderDao支持分页
        List<Order> orders = orderService.getOrdersByUserId(userId, (page - 1) * limit, limit); // 需新增方法
        int count = orderService.getOrderCountByUserId(userId); // 需新增方法
        return new LayuiData(count, orders);
    }

    // 查询订单详情（包括地址和商品）
    @GetMapping("getOrderDetails")
    @ResponseBody
    public Map<String, Object> getOrderDetails(@RequestParam("orderId") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        OrderAddress address = orderService.getOrderAddressByOrderId(orderId); // 需新增方法
        List<OrderInfo> products = orderService.getOrderInfosByOrderId(orderId);

        Map<String, Object> result = new HashMap<>();
        result.put("order", order);
        result.put("address", address);
        result.put("products", products);
        return result;
    }
    // 获取所有订单（管理员专用）
    @GetMapping("getAllOrders")
    @ResponseBody
    public LayuiData getAllOrders(@RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<Order> orders = orderService.getAllOrders((page - 1) * limit, limit); // 新增方法
        int count = orderService.getAllOrdersCount(); // 新增方法
        return new LayuiData(count, orders);
    }

    // 发货操作
    @PostMapping("deliverOrder")
    @ResponseBody
    public int deliverOrder(@RequestParam("orderId") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null && order.getState() == 1) { // 仅在“已付款未发货”状态下可发货
            order.setState(2); // 设置为“已发货未收货”
            order.setDeliverytime(LocalDateTime.now()); // 设置发货时间
            order.setUpdatetime(LocalDateTime.now()); // 更新时间
            orderService.updateOrder(order);
            return 1;
        }
        return 0;
    }
    // 收货操作（新增）
    @PostMapping("receiveOrder")
    @ResponseBody
    public int receiveOrder(@RequestParam("orderId") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order != null && order.getState() == 2) { // 仅在“已发货未收货”状态下可收货
            order.setState(3); // 设置为“已收货”
            order.setReceivetime(LocalDateTime.now()); // 设置收货时间
            order.setUpdatetime(LocalDateTime.now()); // 更新时间
            orderService.updateOrder(order);
            return 1;
        }
        return 0;
    }
}