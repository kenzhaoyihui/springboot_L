package springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.domain.City;
import springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.handler.CityHandler;

@RestController
@RequestMapping(value = "/city")
public class CityController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "")
    public Flux<City> findAllcity() {
        return cityHandler.findAllCity();
    }

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

//    @PostMapping(value = "")
//    public Mono<City> saveCity(@RequestBody City city) {
//        return cityHandler.saveCity(city);
//    }

    @PostMapping(value = "")
    public Mono<City> saveCity(Long id, Long provinceId, String cityName, String description) {
        City city = new City();

        city.setCityName(cityName);
        city.setDescription(description);
        city.setProvinceId(provinceId);
        city.setId(id);
        return cityHandler.saveCity(city);
    }

    @PutMapping(value = "")
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Void> deleteCity1(@PathVariable("id") Long id) {
        return cityHandler.deleteCity1(id);
    }

}
