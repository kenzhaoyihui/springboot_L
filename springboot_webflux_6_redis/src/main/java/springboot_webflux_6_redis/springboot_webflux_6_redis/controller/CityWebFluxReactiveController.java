package springboot_webflux_6_redis.springboot_webflux_6_redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import springboot_webflux_6_redis.springboot_webflux_6_redis.domain.City;

@RestController
@RequestMapping(value = "/city2")
public class CityWebFluxReactiveController {

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        String key = "city_" + id;
        ReactiveValueOperations<String, City> operations = reactiveRedisTemplate.opsForValue();

        Mono<City> city = operations.get(key);
        return city;
    }

//    @PostMapping(value = "")
//    public Mono<City> saveCity(@RequestBody City city) {
//        String key = "city_" + city.getId();
//
//        ReactiveValueOperations<String, City> operations = reactiveRedisTemplate.opsForValue();
//        return operations.getAndSet(key, city);
//    }

    @PostMapping(value = "")
    public Mono<City> saveCity(Long id, Long provinceId, String cityName, String description) {
        City city = new City();
        city.setProvinceId(provinceId);
        city.setId(id);
        city.setCityName(cityName);
        city.setDescription(description);

        String key = "city_" + city.getId();

        ReactiveValueOperations<String, City> operations = reactiveRedisTemplate.opsForValue();
        return operations.getAndSet(key, city);
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        String key = "city_" + id;
        return reactiveRedisTemplate.delete(key);
    }
}
