package springboot_webflux_9_test.springboot_webflux_9_test.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_9_test.springboot_webflux_9_test.dao.CityDao;
import springboot_webflux_9_test.springboot_webflux_9_test.domain.City;

@Component
public class CityHandler {

    private final CityDao cityDao;

    @Autowired
    public CityHandler(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public Mono<City> saveCity(City city) {
        return cityDao.save(city);
    }

    public Mono<City> findCityById(Long id) {
        return cityDao.findById(id);
    }

    public Flux<City> findAllCity() {
        return cityDao.findAll();
    }

    public Mono<City> modifyCity(City city) {
        return cityDao.save(city);
    }

    public Mono<Void> deleteCity(Long id) {
        return cityDao.deleteById(id);
    }

    public Mono<Long> deleteCity1(Long id) {
        cityDao.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }
}
