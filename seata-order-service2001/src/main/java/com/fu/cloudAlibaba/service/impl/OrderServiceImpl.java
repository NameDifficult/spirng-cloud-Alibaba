package com.fu.cloudAlibaba.service.impl;

import com.fu.cloudAlibaba.domain.Order;
import com.fu.cloudAlibaba.mapper.OrderMapper;
import com.fu.cloudAlibaba.service.AccountService;
import com.fu.cloudAlibaba.service.OrderService;
import com.fu.cloudAlibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    OrderMapper orderMapper;
    @Resource
    StorageService storageService;
    @Resource
    AccountService accountService;


    @Override
    @GlobalTransactional(name = "create-order",rollbackFor = Exception.class)//有任何类型的异常都回滚
    public void create(Order order) {
        log.info("开始创建订单");
        orderMapper.create(order);
        storageService.decrease(order.getProductId(),order.getCount());
        accountService.decrease(order.getUserId(),order.getMoney());
        orderMapper.update(order.getUserId(),0);
        log.info("------->下单结束");
    }
}
