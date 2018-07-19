package springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.dao;


import org.springframework.stereotype.Repository;
import springboot_webflux_4_thymeleaf.springboot_webflux_4_thymeleaf.domain.City;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CityDao {

    private ConcurrentMap<Long, City> map = new ConcurrentHashMap<>();

    private static final AtomicLong idGenerator = new AtomicLong(0);

    public Long save(City city) {
        Long id = idGenerator.incrementAndGet();
        city.setId(id);
        map.put(id, city);
        return id;
    }

    public Collection<City> findAll() {
        return map.values();
    }

    public City findCityById(Long id) {
        return map.get(id);
    }

    public Long updateCity(City city) {
        map.put(city.getId(), city);
        return city.getId();
    }

    public Long deleteCity(Long id) {
        map.remove(id);
        return id;
    }
}
