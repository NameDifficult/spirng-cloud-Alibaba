package com.fu.cloudAlibaba.service.impl;

import com.fu.cloudAlibaba.mapper.AccountMapper;
import com.fu.cloudAlibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.math.BigDecimal;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountMapper mapper;


    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("------->account-service中扣减账户余额开始");
        mapper.decrease(userId,money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
