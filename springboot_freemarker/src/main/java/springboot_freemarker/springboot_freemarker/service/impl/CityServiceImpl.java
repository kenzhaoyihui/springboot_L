package springboot_freemarker.springboot_freemarker.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot_freemarker.springboot_freemarker.dao.CityDao;
import springboot_freemarker.springboot_freemarker.domain.City;
import springboot_freemarker.springboot_freemarker.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{

    @Autowired
    CityDao cityDao;

    @Override
    public List<City> findAllCity() {
        //return null;
        return cityDao.findAllCity();
    }

    @Override
    public City findById(Long id) {
        //return null;
        return cityDao.findById(id);
    }

    @Override
    public Long saveCity(City city) {
        //return null;
        return cityDao.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        //return null;
        return cityDao.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        //return null;
        return cityDao.deleteCity(id);
    }
}
