package com.springboot.yzhao.springbootdubboserver.dubbo;

import com.springboot.yzhao.springbootdubboserver.domain.City;

public interface CityDubboService {


    /**
     * city dubbo service
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);
}
