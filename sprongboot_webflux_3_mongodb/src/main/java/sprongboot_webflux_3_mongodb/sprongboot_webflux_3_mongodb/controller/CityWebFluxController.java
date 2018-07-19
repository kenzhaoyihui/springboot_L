package sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.domain.City;
import sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.handler.CityHandler;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping(value = "")
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

//    @PostMapping(value = "")
//    public Mono<City> saveCity(@RequestBody City city) {
//        return cityHandler.save(city);
//    }

    @PostMapping(value = "")
    public Mono<City> saveCity(Long id, Long provinceId, String cityName, String description) {
        City city = new City();
        city.setId(id);
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        city.setDescription(description);
        return cityHandler.save(city);
    }

    @PutMapping(value = "")
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

//    @DeleteMapping(value = "/{id}")
//    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
//        return cityHandler.deleteCity(id);
//    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }

    @DeleteMapping(value = "")
    public Mono<Void> deleteAll() {
        return cityHandler.deleteAll();
    }

}
