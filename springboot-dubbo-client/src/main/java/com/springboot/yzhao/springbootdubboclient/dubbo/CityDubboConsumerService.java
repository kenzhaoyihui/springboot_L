package com.springboot.yzhao.springbootdubboclient.dubbo;


import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.yzhao.springbootdubboclient.domain.City;
import org.springframework.stereotype.Component;

@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public void printCity(String cityName) {
        City city = cityDubboService.findCityByName(cityName);

        System.out.println(city.toString());
    }
}
