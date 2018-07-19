package springboot_webflux_9_test.springboot_webflux_9_test.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import springboot_webflux_9_test.springboot_webflux_9_test.domain.City;

@Repository
public interface CityDao extends ReactiveMongoRepository<City, Long> {
}
