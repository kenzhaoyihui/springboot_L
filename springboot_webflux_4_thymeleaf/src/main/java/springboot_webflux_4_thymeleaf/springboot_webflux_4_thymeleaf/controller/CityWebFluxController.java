package springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.domain.City;
import springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.handler.CityHandler;

@Controller
@RequestMapping(value = "/city")
public class CityWebFluxController {

    @Autowired
    CityHandler cityHandler;

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping(value = "")
    @ResponseBody
    public Flux<City> findAll() {
        return cityHandler.findAll();
    }

//    @PostMapping(value = "")
//    @ResponseBody
//    public Mono<Long> saveCity(@RequestBody City city) {
//        return cityHandler.save(city);
//    }

    @PostMapping(value = "")
    @ResponseBody
    public Mono<Long> saveCity(Long id, Long provinceId, String cityName, String description) {
        City city = new City();
        city.setId(id);
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        city.setDescription(description);
        return cityHandler.save(city);
    }

    @PutMapping(value = "")
    @ResponseBody
    public Mono<Long> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public Mono<Long> deleteCity(@PathVariable("id") Long id) {
        return cityHandler.deleteCity(id);
    }

    @GetMapping(value = "/hello")
    public Mono<String> hello(Model model) {
        model.addAttribute("name", "ZYH");
        model.addAttribute("city", "Nanjing");

        String path = "hello";
        return Mono.create(monoSink -> monoSink.success(path));
    }

    private static final String CITY_LIST_PATH_NAME = "cityListPage";
    @GetMapping(value = "/list")
    public String listPage(final Model model) {
        final Flux<City> cityFluxList = cityHandler.findAll();
        model.addAttribute("cityList", cityFluxList);

        return CITY_LIST_PATH_NAME;

    }
}
