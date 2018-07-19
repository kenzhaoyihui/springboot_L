package springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.domain.City;

@Repository
public interface CityDao extends ReactiveMongoRepository<City, Long> {
    //Mono<City> findCityByName(String cityName);
    Mono<City> findByCityName(String cityName); // 这边有坑， jpa按照特定得方法名去查询, 所以上面得方法有问题
}
