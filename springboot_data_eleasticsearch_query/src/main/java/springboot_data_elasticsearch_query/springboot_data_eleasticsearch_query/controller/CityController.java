package springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.domain.City;
import springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.service.CityService;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    /**
     * insert a city
     * @param city
     * @return
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
    public Long createCity(@RequestBody City city) {
        return cityService.saveCity(city);
    }


    @RequestMapping(value = "/api/city/search", method = RequestMethod.GET)
    public List<City> searchCity(@RequestParam("pageNumber") Integer pageNumber,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("searchContent") String searchContent) {
        return cityService.searchCity(pageNumber, pageSize, searchContent);
    }

}
