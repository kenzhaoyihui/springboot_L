package springboot_freemarker.springboot_freemarker.service;

import springboot_freemarker.springboot_freemarker.domain.City;

import java.util.List;

public interface CityService {

    List<City> findAllCity();

    City findById(Long id);

    Long saveCity(City city);

    Long updateCity(City city);

    Long deleteCity(Long id);
}
