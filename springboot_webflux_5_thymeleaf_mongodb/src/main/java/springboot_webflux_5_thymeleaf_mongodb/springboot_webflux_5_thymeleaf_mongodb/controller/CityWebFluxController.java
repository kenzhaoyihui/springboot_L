package springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.domain.City;
import springboot_webflux_5_thymeleaf_mongodb.springboot_webflux_5_thymeleaf_mongodb.handler.CityHandler;

@Controller
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    private CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping(value = "")
    @ResponseBody
    public Flux<City> findAllcity() {
        return cityHandler.findAllcity();
    }

//    @PostMapping(value = "")
//    @ResponseBody
//    public Mono<City> saveCity(@RequestBody City city) {
//        return cityHandler.saveCity(city);
//    }

    @PostMapping(value = "")
    @ResponseBody
    public Mono<City> saveCity(Long id, Long provinceId, String cityName, String description) {
        City city = new City();
        city.setId(id);
        city.setDescription(description);
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        return cityHandler.saveCity(city);
    }

    @PutMapping(value = "")
    @ResponseBody
    public Mono<City> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Mono<Void> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    @ResponseBody
    public Mono<Long> deleteCity1(@PathVariable("id") Long id) {
        return cityHandler.deleteCity1(id);
    }


    private static final String CITY_LIST_PATH_NAME = "cityList";
    private static final String CITY_PATH_NAME = "city";

    @GetMapping(value = "/page/list")
    public String listPage(final Model model) {
        final Flux<City> cityFluxList = cityHandler.findAllcity();
        model.addAttribute("cityList", cityFluxList);
        return CITY_LIST_PATH_NAME;
    }

    @GetMapping(value = "/getByName")
    public String getCityByName(final Model model, @RequestParam("cityName") String cityName) {
        final Mono<City> cityMono = cityHandler.getCityByName(cityName);
        model.addAttribute("city", cityMono);
        return CITY_PATH_NAME;
    }


}
