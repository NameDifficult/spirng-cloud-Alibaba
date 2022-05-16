package com.fu.cloudAlibaba.controller;

import com.fu.cloudAlibaba.service.OrderFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return orderFeignService.getPayment(id);
    }
}
