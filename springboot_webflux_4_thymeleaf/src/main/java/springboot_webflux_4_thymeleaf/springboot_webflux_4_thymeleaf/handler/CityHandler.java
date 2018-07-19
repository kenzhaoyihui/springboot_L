package springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.dao.CityDao;
import springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.domain.City;

@Component
public class CityHandler {

    private final CityDao cityDao;

    @Autowired
    public CityHandler(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public Mono<Long> save(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityDao.save(city)));
    }

    public Mono<City> findCityById(Long id) {
        return Mono.justOrEmpty(cityDao.findCityById(id));
    }

    public Flux<City> findAll() {
        return Flux.fromIterable(cityDao.findAll());
    }

    public Mono<Long> modifyCity(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityDao.updateCity(city)));
    }

    public Mono<Long> deleteCity(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityDao.deleteCity(id)));
    }
}
