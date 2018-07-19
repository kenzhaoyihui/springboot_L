package sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.domain.City;


@Repository
public interface CityRepository extends ReactiveMongoRepository<City, Long> {
}
