package com.fu.cloudAlibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fu.springcloud.ben.CommonResult;
import com.fu.springcloud.ben.Payment;

public class CustomerBlockHandler {


    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"  服务不可用------1");
    }


    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444,exception.getClass().getCanonicalName()+"  服务不可用------2");
    }


}
