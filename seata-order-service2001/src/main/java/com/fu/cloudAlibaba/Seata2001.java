package com.fu.cloudAlibaba;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)//取消数据源的自动建立
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.fu.cloudAlibaba.mapper")
public class Seata2001 {
    public static void main(String[] args) {
        SpringApplication.run(Seata2001.class,args);
    }
}
