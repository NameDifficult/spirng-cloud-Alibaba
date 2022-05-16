package com.fu.cloudAlibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class SentinelController {

    @GetMapping("/testA")
    public String testA()
    {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB()
    {
        return "------testB";
    }


    //测试熔断降级
    @GetMapping("/testD")
    public String testD()
    {
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

    //测试熔断降级
    @GetMapping("/testE")
    public String testE()
    {
        //暂停几秒钟线程
        int k = 10/0;
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testE 测试异常比例和异常数");
        return "------testE";
    }



    //测试热点限流   规则在控制台配
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_Hotkey")//参数一：作为配置限流的资源名 参数二：fallback方法
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2)
    {
            return "------testHotKey";
    }
    //blockHandler方法，热点参数限流后返回的友好页面
    public String deal_Hotkey(String p1, String p2, BlockException blockException){
        return "deal_Hotkey   o(╥﹏╥)o";
    }

}
