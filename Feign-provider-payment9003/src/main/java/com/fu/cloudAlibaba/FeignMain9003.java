package com.fu.cloudAlibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeignMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(FeignMain9003.class,args);
    }
}
