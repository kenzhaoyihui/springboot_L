package springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.domain.City;

public interface CityService {

    Flux<City> findAllCity();

    Mono<City> findCityById(Long id);

    Mono<City> saveCity(City city);

    Mono<City> updateCity(City city);

    Mono<Void> deleteCity(Long id);
}
