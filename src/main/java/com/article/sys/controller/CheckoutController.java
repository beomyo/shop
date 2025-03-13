package com.article.sys.controller;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.article.sys.bean.*;
import com.article.sys.service.ICartService;
import com.article.sys.service.IOrderService;
import com.article.sys.service.IUserService;
import com.article.sys.util.LayuiData;
import com.article.sys.util.PaymentCheckUtil;
import com.article.sys.util.PaymentUtil;
import com.article.sys.util.SYS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICartService cartService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/addresses")
    @ResponseBody
    public LayuiData getAddresses(HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            List<UserAddress> addresses = userService.getUserAddresses(currentUser.getId());
            return new LayuiData(addresses.size(), addresses);
        }
        return new LayuiData();
    }

    @GetMapping("/selectedItems")
    @ResponseBody
    public List<Map<String, Object>> getSelectedItems(HttpSession session) {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser != null) {
            return cartService.getSelectedItemsWithProductDetails(currentUser.getId());
        }
        return Collections.emptyList();
    }

    @PostMapping("/submitOrder")
    @ResponseBody
    @Transactional
    public String submitOrder(@RequestBody Map<String, Object> orderData, HttpSession session) throws AlipayApiException {
        User currentUser = (User) session.getAttribute(SYS.SHOPPING_LOGIN_USER);
        if (currentUser == null) {
            return "用户未登录";
        }

        Map<String, Object> address = (Map<String, Object>) orderData.get("address");
        List<Map<String, Object>> products = (List<Map<String, Object>>) orderData.get("products");
        Double totalPrice = Double.parseDouble(orderData.get("totalPrice").toString());

        Order order = new Order();
        order.setCode(IdUtil.getSnowflake(1, 1).nextIdStr());
        order.setUserid(currentUser.getId());
        order.setMoney(totalPrice);
        order.setAddtime(LocalDateTime.now());
        order.setState(0);
        orderService.addOrder(order);

        OrderAddress orderAddress = new OrderAddress();
        orderAddress.setOrderid(order.getId());
        orderAddress.setAddress(address.get("province") + " " + address.get("city") + " " +
                address.get("area") + " " + address.get("address"));
        orderAddress.setName(address.get("name").toString());
        orderAddress.setTel(address.get("tel").toString());
        orderService.addOrderAddress(orderAddress);

        for (Map<String, Object> product : products) {
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrderid(order.getId());
            orderInfo.setProductid(Integer.parseInt(product.get("productid").toString()));
            orderInfo.setNumber(Integer.parseInt(product.get("number").toString()));
            orderInfo.setPrice(Double.parseDouble(product.get("addprice").toString()));
            orderInfo.setProcductname(product.get("productName").toString());
            orderInfo.setImgurl(product.get("productImg").toString());
            orderService.addOrderInfo(orderInfo);
        }

        String url = PaymentUtil.getPaymentUrl(order);
        if (url == null) {
            throw new RuntimeException("生成支付二维码失败");
        }
        BufferedImage img = QrCodeUtil.generate(url, 300, 300);
        String qrcode = ImgUtil.toBase64(img, "png");

        JSONObject response = new JSONObject();
        response.put("code", 0);
        response.put("msg", "订单生成成功");
        response.put("qrcode", qrcode);
        response.put("orderId", order.getId());
        return response.toJSONString();
    }

    // 支付状态检查接口（保留作为备用，之前是主动查询）
    @PostMapping("/checkPayment")
    @ResponseBody
    public String checkPayment(@RequestParam("orderId") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        if (order == null) {
            return "订单不存在";
        }
        String result = PaymentCheckUtil.Paycheck(order);
        if ("TRADE_SUCCESS".equals(result)) {
            order.setState(1);
            order.setPaymenttime(LocalDateTime.now());
            orderService.updateOrder(order);

            List<OrderInfo> orderInfos = orderService.getOrderInfosByOrderId(orderId);
            Integer userId = order.getUserid();
            for (OrderInfo orderInfo : orderInfos) {
                Integer productId = orderInfo.getProductid();
                cartService.deleteInCartByUserIdAndProductId(userId, productId);
            }
            return "支付成功";
        }
        return "支付未完成";
    }

    // 支付宝异步通知处理
    @PostMapping("/notify")
    @ResponseBody
    public String handleAlipayNotify(HttpServletRequest request) {
        String tradeStatus = request.getParameter("trade_status");
        String outTradeNo = request.getParameter("out_trade_no"); // 获取订单号
        System.out.println("收到支付宝异步通知，trade_status = " + tradeStatus + ", out_trade_no = " + outTradeNo);

        if ("TRADE_SUCCESS".equals(tradeStatus)) {
            // 根据订单号查询订单
            Order order = orderService.getOrderByCode(outTradeNo);
            if (order != null && order.getState() == 0) { // 确保订单未支付状态
                order.setState(1); // 更新为已支付
                order.setPaymenttime(LocalDateTime.now());
                order.setUpdatetime(LocalDateTime.now());
                orderService.updateOrder(order);

                // 清空购物车
                List<OrderInfo> orderInfos = orderService.getOrderInfosByOrderId(order.getId());
                Integer userId = order.getUserid();
                for (OrderInfo orderInfo : orderInfos) {
                    Integer productId = orderInfo.getProductid();
                    cartService.deleteInCartByUserIdAndProductId(userId, productId);
                }
            }
        }
        return "success"; // 通知支付宝处理成功
    }

    // 新增接口：前端轮询检查订单状态
    @GetMapping("/checkOrderStatus")
    @ResponseBody
    public JSONObject checkOrderStatus(@RequestParam("orderId") Integer orderId) {
        Order order = orderService.getOrderById(orderId);
        JSONObject response = new JSONObject();
        if (order == null) {
            response.put("status", "error");
            response.put("msg", "订单不存在");
        } else if (order.getState() == 1) {
            response.put("status", "success");
            response.put("msg", "支付成功");
        } else {
            response.put("status", "pending");
            response.put("msg", "支付未完成");
        }
        return response;
    }
}