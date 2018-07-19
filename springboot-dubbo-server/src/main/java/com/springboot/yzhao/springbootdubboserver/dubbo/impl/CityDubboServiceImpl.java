package com.springboot.yzhao.springbootdubboserver.dubbo.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.yzhao.springbootdubboserver.domain.City;
import com.springboot.yzhao.springbootdubboserver.dubbo.CityDubboService;

@Service(version = "1.0.0")
public class CityDubboServiceImpl implements CityDubboService {
    @Override
    public City findCityByName(String cityName) {
        //return null;

        return new City(1L, 2L, "Nanjing", "Nanjing is a nice city");
    }
}
