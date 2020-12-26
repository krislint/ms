package com.moelyon.ms.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.moelyon.ms.api.service.SayHelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * sayhello implment
 *
 * @author : wlt
 * @date : 2020-12-22 17:35
 **/
@DubboService
//@Component
public class SayHelloServiceImpl implements SayHelloService {
    @Override
    public String sayhello(String name) {
        return "hello "+name;
    }
}
