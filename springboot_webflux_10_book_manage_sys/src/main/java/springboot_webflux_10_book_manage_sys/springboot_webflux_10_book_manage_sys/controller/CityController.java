package springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.domain.City;
import springboot_webflux_10_book_manage_sys.springboot_webflux_10_book_manage_sys.service.CityService;

@Controller
@RequestMapping(value = "/city")
public class CityController {

    private static final String CITY_FORM_PATH_NAME = "cityForm";
    private static final String CITY_LIST_PATH_NAME = "cityList";
    private static final String REDIRECT_TO_CITY_URL = "redirect:/city";

    @Autowired
    private CityService cityService;

    @RequestMapping(method = RequestMethod.GET)
    public String getCityList(Model model) {
        model.addAttribute("cityList", cityService.findAllCity());
        return CITY_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createCityForm(Model model) {
        model.addAttribute("city", new City());
        model.addAttribute("action", "create");
        return CITY_FORM_PATH_NAME;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postCity(@ModelAttribute City city) {
        cityService.saveCity(city);
        return REDIRECT_TO_CITY_URL;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getCity(@PathVariable Long id, Model model) {
        final Mono<City> city = cityService.findCityById(id);
        model.addAttribute("city", city);
        model.addAttribute("action", "update");
        return CITY_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putCity(@ModelAttribute City city) {
        cityService.updateCity(city);
        return REDIRECT_TO_CITY_URL;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        //return CITY_LIST_PATH_NAME;
        return REDIRECT_TO_CITY_URL;
        //return Mono.create(monoSink -> monoSink.success(REDIRECT_TO_CITY_URL));
    }

//    @GetMapping(value = "/list")
//    @ResponseBody
//    public Flux<City> findAllCity() {
//        return cityService.findAllCity();
//    }
//
//    @GetMapping(value = "/list/{id}")
//    @ResponseBody
//    public Mono<City> findCityById(@PathVariable Long id) {
//        return cityService.findCityById(id);
//    }
//
//    @PostMapping(value = "/add")
//    @ResponseBody
//    public Mono<City> saveCity(Long id, Long provinceId, String cityName, String description) {
//        City city = new City();
//        city.setId(id);
//        city.setDescription(description);
//        city.setCityName(cityName);
//        city.setProvinceId(provinceId);
//        return cityService.saveCity(city);
//    }
//
//    @DeleteMapping(value = "/delete1/{id}")
//    @ResponseBody
//    public Mono<Void> deleteCity1(@PathVariable Long id) {
//        return cityService.deleteCity(id);
//    }
}
