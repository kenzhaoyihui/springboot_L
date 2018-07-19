package sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.dao.CityRepository;
import sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.domain.City;

@Component
public class CityHandler {

    private CityRepository cityRepository;

    @Autowired
    public CityHandler(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public Mono<City> save(City city) {
        return cityRepository.save(city);
    }

    public Flux<City> findAllCity() {
        return cityRepository.findAll();
    }

    public Mono<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public Mono<City> modifyCity(City city) {
        return cityRepository.save(city);
    }

//    public Mono<Long> deleteCity(Long id) {
//        cityRepository.deleteById(id);
//        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
//    }

    public Mono<Void> deleteCity(Long id) {
        return cityRepository.deleteById(id);
    }

    public Mono<Void> deleteAll() {
        return cityRepository.deleteAll();
    }
}
