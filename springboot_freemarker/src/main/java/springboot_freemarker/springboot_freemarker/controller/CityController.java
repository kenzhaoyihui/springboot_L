package springboot_freemarker.springboot_freemarker.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot_freemarker.springboot_freemarker.domain.City;
import springboot_freemarker.springboot_freemarker.service.CityService;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findById(id));
        return "city";
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public String findAllCitys(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList", cityList);
        return "cityList";
    }

    @RequestMapping(value = "/api/city/add", method = RequestMethod.POST)
    @ResponseBody
    public String saveCity(Long id, Long provinceId, String cityName, String description) {
        City city = new City();
        city.setId(id);
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        city.setDescription(description);
        long t = cityService.saveCity(city);
        if (t == 1) {
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/api/city/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateCity(@PathVariable("id") Long id, Long provinceId, String cityName, String description) {
        City city = cityService.findById(id);
        city.setProvinceId(provinceId);
        city.setCityName(cityName);
        city.setDescription(description);
        Long t = cityService.updateCity(city);

        if (t == 1) {
            return "success";
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/api/city/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCityById(@PathVariable("id") Long id) {
        Long t = cityService.deleteCity(id);

        if (t == 1) {
            return "delete successfully";
        }else {
            return "delete operation failed";
        }
    }
}
