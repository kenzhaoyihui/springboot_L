package springboot_webflux_6_redis.springboot_webflux_6_redis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import springboot_webflux_6_redis.springboot_webflux_6_redis.domain.City;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        String key = "city_" + id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        boolean hasKey = redisTemplate.hasKey(key);
        City city = operations.get(key);

        if(!hasKey) {
            return Mono.create(monoSink -> monoSink.success(null));
        }
        return Mono.create(monoSink -> monoSink.success(city));
    }

//    @PostMapping(value = "")
//    public Mono<City> saveCity(@RequestBody City city) {
//        String key = "city_" + city.getId();
//        ValueOperations<String, City> operations = redisTemplate.opsForValue();
//        operations.set(key, city, 60, TimeUnit.SECONDS);
//
//        return Mono.create(monoSink -> monoSink.success(city));
//    }

    @PostMapping(value = "")
    public Mono<City> saveCity(Long id, Long provinceId, String cityName, String description) {
        String key = "city_" + id;
        City city = new City();
        city.setId(id);
        city.setCityName(cityName);
        city.setDescription(description);
        city.setProvinceId(provinceId);

        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        //operations.set(key, city, 60, TimeUnit.SECONDS);
        operations.set(key, city);

        return Mono.create(monoSink -> monoSink.success(city));
    }

    @DeleteMapping(value = "/{id}")
    public Mono<Void> deleteCity(@PathVariable("id") Long id) {
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            redisTemplate.delete(key);
        }

        return Mono.create(monosink -> monosink.success());
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Long> deleteCity1(@PathVariable("id") Long id) {
        String key = "city_" + id;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            redisTemplate.delete(key);
        }

        return Mono.create(monoSink -> monoSink.success(id));
    }
}
