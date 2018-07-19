package springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.dao.CityDao;
import springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.domain.City;

@Component
public class CityHandler {

    private static final Logger logger = LoggerFactory.getLogger(CityHandler.class);

    @Autowired
    private RedisTemplate redisTemplate;

    private final CityDao cityDao;

    @Autowired
    public CityHandler(CityDao cityDao) {
        this.cityDao = cityDao;
    }


    public Mono<City> saveCity(City city) {
        return cityDao.save(city);
    }

    public Flux<City> findAllCity() {
        return cityDao.findAll().cache();
    }

    public Mono<City> findCityById(Long id) {
        // 从缓存中获取城市信息
        String key = "city-" + id;

        ValueOperations<String, City> operations = redisTemplate.opsForValue();

        boolean hasKey = redisTemplate.hasKey(key);
        // 缓存存在
        if (hasKey) {
            City city = operations.get(key);

            logger.info("CityHandler.findCityById(): city find in cache--->" + city.toString());
            return Mono.create(cityMonoSink -> cityMonoSink.success(city));
        }

        // 缓存bu存在, 从 MongoDB 中获取城市信息
        Mono<City> cityMono = cityDao.findById(id);
        if (cityMono == null) {
            return cityMono;
        }

        // 插入缓存
        cityMono.subscribe(cityObj -> {
            operations.set(key, cityObj);
            logger.info("CityHandler.findCityById(): city insert cache-->" + cityObj.toString());
        });
        return cityMono;
    }


    public Mono<City> modifyCity(City city) {
        // 缓存存在，删除缓存
        String key = "city-" + city.getId();
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("CityHandler.modifyCity(): delete city from cache --> " + city.getId());
        }

        return cityDao.save(city).cache();
    }

    public Mono<Long> deleteCity(Long id) {
        String key = "city-" + id;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("CityHandler.deleteCity(): delete city from cache --> " + id);
        }

        cityDao.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }

    public Mono<Void> deleteCity1(Long id) {
        String key = "city-" + id;
        boolean hasKey = redisTemplate.hasKey(key);

        if (hasKey) {
            redisTemplate.delete(key);
            logger.info("CityHandler.deleteCity(): delete city from cachee --> " + id);
        }

        return cityDao.deleteById(id);
        //return Mono.create(cityMonoSink -> cityMonoSink.success());
    }
}
