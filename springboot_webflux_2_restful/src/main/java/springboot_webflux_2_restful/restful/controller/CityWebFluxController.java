package springboot_webflux_2_restful.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_2_restful.restful.domain.City;
import springboot_webflux_2_restful.restful.handler.CityHandler;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return  cityHandler.findCityById(id);
    }

    @GetMapping("")
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

//    @PostMapping()
//    public Mono<Long> saveCity(Long id, Long provinceId, String cityName, String description) {
//        City city = new City();
//        city.setId(id);
//        city.setProvinceId(provinceId);
//        city.setCityName(cityName);
//        city.setDescription(description);
//        return cityHandler.save(city);
//    }

    @PostMapping("")
    public Mono<Long> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @PutMapping()
    public Mono<Long> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }
}
