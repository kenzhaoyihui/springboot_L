package springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.domain.City;

@Repository
public interface CityDao extends ReactiveMongoRepository<City, Long> {

}
