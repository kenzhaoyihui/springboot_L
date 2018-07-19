package springboot_webflux_9_test.springboot_webflux_9_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_9_test.springboot_webflux_9_test.domain.City;
import springboot_webflux_9_test.springboot_webflux_9_test.handler.CityHandler;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    public Mono<City> findCitybyId(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping(value = "")
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @PostMapping(value = "")
    public Mono<City> saveCity(@RequestBody City city) {
        return cityHandler.saveCity(city);
    }

//    @PostMapping(value = "")
//    public Mono<City> saveCity1(Long id, Long provinceId, String cityName, String description) {
//        City city = new City();
//        city.setCityName(cityName);
//        city.setId(id);
//        city.setDescription(description);
//        city.setProvinceId(provinceId);
//
//        return cityHandler.saveCity(city);
//    }

    @PutMapping(value = "")
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Long> deleteCity1(@PathVariable("id") Long id) {
        return cityHandler.deleteCity1(id);
    }
}
