package springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.handler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.dao.CityDao;
import springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.domain.City;

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

    public Flux<City> findAllcity() {
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

    public Mono<City> getCityByName(String cityName) {
        return cityDao.findByCityName(cityName);
    }

}
