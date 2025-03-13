package com.article.sys.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.domain.AlipayTradePrecreateModel;
import com.alipay.api.domain.ExtendParams;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.domain.GoodsDetail;
import com.alipay.api.domain.BusinessParams;
import com.alipay.api.request.AlipayTradePrecreateRequest;

import com.alipay.api.FileItem;
import com.article.sys.bean.Order;

import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class PaymentUtil {

    private static String PaymentFunction(Order order) throws AlipayApiException {
        // 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());

        // 构造请求参数以调用接口
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        AlipayTradePrecreateModel model = new AlipayTradePrecreateModel();

        // 设置商户订单号
        model.setOutTradeNo(order.getCode());

        // 设置订单总金额
        model.setTotalAmount(order.getMoney().toString());

        // 设置订单标题
        model.setSubject("商城项目支付");

        // 设置产品码
        model.setProductCode("FACE_TO_FACE_PAYMENT");

        // 设置卖家支付宝用户ID
        model.setSellerId(SYS.SELLER);

        BusinessParams businessParams = new BusinessParams();
        businessParams.setMcCreateTradeIp("127.0.0.1");
        model.setBusinessParams(businessParams);


        request.setBizModel(model);
        request.setNotifyUrl(SYS.NOTIFY_URL);
        // 第三方代调用模式下请设置app_auth_token
        // request.putOtherTextParam("app_auth_token", "<-- 请填写应用授权令牌 -->");

        AlipayTradePrecreateResponse response = alipayClient.execute(request);


        if (response.isSuccess()) {
            String body=response.getBody();
            JSONObject obj= JSON.parseObject(body);
            obj=obj.getJSONObject("alipay_trade_precreate_response");
//            System.out.println("调用成功");
            return obj.getString("qr_code");
        } else {
//            System.out.println("调用失败");
            return null;
        }
    }

    private static AlipayConfig getAlipayConfig() {
        String privateKey = SYS.PRIVATE_KET;
        String alipayPublicKey = SYS.ALIPAY_PUBLIC_KEY;
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl("https://openapi-sandbox.dl.alipaydev.com/gateway.do");
        alipayConfig.setAppId(SYS.APPID);
        alipayConfig.setPrivateKey(privateKey);
        alipayConfig.setFormat("json");
        alipayConfig.setAlipayPublicKey(alipayPublicKey);
        alipayConfig.setCharset("UTF-8");
        alipayConfig.setSignType("RSA2");
        return alipayConfig;
    }
    public static String getPaymentUrl(Order order){
        String url;
        for (int i = 1; i < 6; i++) {
            try {
                url=PaymentUtil.PaymentFunction(order);
                System.out.println("成功获取二维码");
                return url;
            }catch (Exception e){
                System.out.println("获取二维码失败,第"+i+"次重试");
            }
        }
        //获取验证码失败，取消订单，未实现

        return null;

    }
}