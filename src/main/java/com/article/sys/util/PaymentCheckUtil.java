package com.article.sys.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.domain.AlipayTradeQueryModel;

import com.alipay.api.FileItem;
import com.article.sys.bean.Order;

import java.util.Base64;
import java.util.ArrayList;
import java.util.List;

public class PaymentCheckUtil {

    private static String alicheck(Order order) throws AlipayApiException {
        // 初始化SDK
        AlipayClient alipayClient = new DefaultAlipayClient(getAlipayConfig());

        // 构造请求参数以调用接口
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        AlipayTradeQueryModel model = new AlipayTradeQueryModel();

        // 设置订单支付时传入的商户订单号
        model.setOutTradeNo(order.getCode());

        // 设置支付宝交易号
//        model.setTradeNo("2014112611001004680 073956707");

        // 设置银行间联模式下有用
//        model.setOrgPid("2088101117952222");

        // 设置查询选项
        List<String> queryOptions = new ArrayList<String>();
        queryOptions.add("trade_settle_info");
        model.setQueryOptions(queryOptions);

        request.setBizModel(model);
        // 第三方代调用模式下请设置app_auth_token
        // request.putOtherTextParam("app_auth_token", "<-- 请填写应用授权令牌 -->");


        AlipayTradeQueryResponse response = alipayClient.execute(request);
//        System.out.println(response.getBody());



        if (response.isSuccess()) {
            String body=response.getBody();
            System.out.println(body);
            JSONObject obj= JSON.parseObject(body);
            obj=obj.getJSONObject("alipay_trade_query_response");
            String result=obj.getString("msg");
            if(result.equals("Success")){
                return "成功";
            } else if (result.equals("Business Failed")) {
                return "交易不存在,没有该Code";
            } else return "error";
            //交易不存在

        } else {
            return "error";
        }


    }

    private static AlipayConfig getAlipayConfig() {
        String privateKey  = SYS.PRIVATE_KET;
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
    public static String Paycheck(Order order)  {
        String result=null;
        for (int i = 1; i < 11; i++) {
            try {
                result=alicheck(order);
                if(result.equals("成功")){
                    return "成功";
                }
//                else return "失败";
            } catch (AlipayApiException e) {

                System.out.println("失败,重试第"+i+"次");
            }
        }
        return "失败";
    }

}