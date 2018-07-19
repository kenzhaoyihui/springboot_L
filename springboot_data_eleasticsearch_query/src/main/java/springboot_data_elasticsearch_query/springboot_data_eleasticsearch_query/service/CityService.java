package springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.service;

import springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.domain.City;

import java.util.List;

public interface CityService {

    /**
     * add the city
     * @param city
     * @return
     */
    Long saveCity(City city);

    /**
     * search the city, return the city information
     * @param pageNumber
     * @param pageSize
     * @param searchContent
     * @return
     */
    List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent);
}
