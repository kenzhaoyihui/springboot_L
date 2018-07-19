package springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.dao.CityDao;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.domain.City;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    @Autowired
    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public Flux<City> findAllCity() {
        //return null;
        return cityDao.findAll();
    }

    @Override
    public Mono<City> findCityById(Long id) {
        //return null;
        return cityDao.findById(id);
    }

    @Override
    public Mono<City> saveCity(City city) {
        //return null;
        return cityDao.save(city);
    }

    @Override
    public Mono<City> updateCity(City city) {
        //return null;
        return cityDao.save(city);
    }

    @Override
    public Mono<Void> deleteCity(Long id) {
        //return null;
        return cityDao.deleteById(id);
    }
}
