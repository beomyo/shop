package com.article.sys.util;

import com.article.sys.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CancelOrder {
    @Autowired
    IOrderService orderService;
    @Scheduled(fixedRate = 1000*60)
    public void cancelOrder(){
        orderService.cancleOrder();
    }
}
