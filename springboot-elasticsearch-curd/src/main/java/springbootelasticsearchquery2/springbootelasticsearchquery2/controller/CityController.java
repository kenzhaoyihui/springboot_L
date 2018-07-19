package springbootelasticsearchquery2.springbootelasticsearchquery2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootelasticsearchquery2.springbootelasticsearchquery2.domain.City;
import springbootelasticsearchquery2.springbootelasticsearchquery2.service.CityService;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    CityService cityService;

    /**
     * insert city
     * @param id
     * @param name
     * @param description
     * @param score
     * @return
     */

    @RequestMapping(value = "/api/city", method = RequestMethod.POST)
//    public Long createCity(@RequestBody City city) {
//        return cityService.saveCity(city);
//    }
    public Long createCity(Long id, String name, String description, Integer score) {
        City city = new City();
        city.setId(id);
        city.setDescription(description);
        city.setName(name);
        city.setScore(score);
        return cityService.saveCity(city);
    }

    @RequestMapping(value = "/api/city/and/find", method = RequestMethod.GET)
    public List<City> findByDescriptionAndScore(@RequestParam("description") String description,
                                                @RequestParam("score") Integer score) {
        return cityService.findByDescriptionAndScore(description, score);
    }


    @RequestMapping(value = "/api/city/or/find", method = RequestMethod.GET)
    public List<City> findByDescriptionByScore(@RequestParam("description") String description,
                                               @RequestParam("score") Integer score) {
        return cityService.findByDescriptionOrScore(description, score);
    }

    @RequestMapping(value = "/api/city/description/find", method = RequestMethod.GET)
    public List<City> findByDescription(@RequestParam("description") String description) {
        return cityService.findByDescription(description);
    }


    @RequestMapping(value = "/api/city/not/find", method = RequestMethod.GET)
    public List<City> findByDescriptionNot(@RequestParam("description") String description) {
        return cityService.findByDescriptionNot(description);
    }


    @RequestMapping(value = "/api/city/like/find", method = RequestMethod.GET)
    public List<City> findByDescriptionLike(@RequestParam("description") String desciption) {
        return cityService.findByDescriptionLike(desciption);
    }

    /**
     *
     * http://127.0.0.1:8080/api/city?id=3000&name=Beijing&description=beijing nanjing is a big city&score=80
     * http://127.0.0.1:8080/api/city?id=2000&name=Nanjing&description=nanjing is a nice city&score=100
     * http://127.0.0.1:8080/api/city/search?pageNumber=0&pageSize=10&searchContent=nanjing
     *
    2018-07-15 17:49:01.890  INFO 19167 --- [io-8080-exec-10] s.s.service.impl.CityServiceImpl         :
    searchCity: searchContent [nanjing]
    DSL =
    {
        "function_score" : {
        "functions" : [ {
            "filter" : {
                "match" : {
                    "name" : {
                        "query" : "nanjing",
                                "type" : "phrase"
                    }
                }
            },
            "weight" : 1000.0
        }, {
            "filter" : {
                "match" : {
                    "description" : {
                        "query" : "nanjing",
                                "type" : "phrase"
                    }
                }
            },
            "weight" : 500.0
        } ],
        "score_mode" : "sum",
                "min_score" : 10.0
    }
    }
    */

}
