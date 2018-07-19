package springbootelasticsearchquery2.springbootelasticsearchquery2.service;

import springbootelasticsearchquery2.springbootelasticsearchquery2.domain.City;

import java.util.List;

public interface CityService {

    /**
     * add the city
     * @param city
     * @return
     */
    Long saveCity(City city);

//    /**
//     * search the city, return the city information
//     * @param pageNumber
//     * @param pageSize
//     * @param searchContent
//     * @return
//     */
//    List<City> searchCity(Integer pageNumber, Integer pageSize, String searchContent);


    List<City> findByDescriptionAndScore(String description, Integer score);


    List<City> findByDescriptionOrScore(String description, Integer score);

    List<City> findByDescription(String description);

    List<City> findByDescriptionNot(String description);

    List<City> findByDescriptionLike(String description);
}

