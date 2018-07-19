package com.yzhao.springboot.client.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yzhao.springboot.api.service.EchoService;
import org.springframework.stereotype.Component;

@Component
public class EchoClientService {

    @Reference(version = "1.0.0")
    public EchoService echoService;
}
