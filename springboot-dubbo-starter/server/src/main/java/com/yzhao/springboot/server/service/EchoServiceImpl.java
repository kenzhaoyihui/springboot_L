package com.yzhao.springboot.server.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.yzhao.springboot.api.service.EchoService;

@Service(version = "1.0.0")
public class EchoServiceImpl implements EchoService {
    @Override
    public String echo(String str) {
        //return null;
        System.out.println(str);
        return str;
    }
}
