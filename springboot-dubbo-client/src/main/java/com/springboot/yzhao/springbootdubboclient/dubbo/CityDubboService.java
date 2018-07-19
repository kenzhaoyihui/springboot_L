package com.springboot.yzhao.springbootdubboclient.dubbo;

import com.springboot.yzhao.springbootdubboclient.domain.City;

public interface CityDubboService {

    /**
     * find city via cityName
     * @param cityName
     * @return
     */
    City findCityByName(String cityName);
}
