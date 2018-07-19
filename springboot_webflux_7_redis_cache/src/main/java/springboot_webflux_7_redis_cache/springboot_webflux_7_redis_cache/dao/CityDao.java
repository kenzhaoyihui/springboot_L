package springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.domain.City;

@Repository
public interface CityDao extends ReactiveMongoRepository<City, Long> {

}
