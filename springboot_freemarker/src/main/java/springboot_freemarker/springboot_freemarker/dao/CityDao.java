package springboot_freemarker.springboot_freemarker.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import springboot_freemarker.springboot_freemarker.domain.City;

import java.util.List;

@Mapper
public interface CityDao {

    /**
     * get all city info
     * @return
     */

    @Select("select id, province_id, city_name, description from city")

    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })
    List<City> findAllCity();


    @Select("select * from city where id=#{id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId", column = "province_id"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "description", column = "description"),
    })

    City findById(@Param("id") Long id);

    @Insert("insert into city (id, province_id, city_name, description) values (#{id}, #{provinceId}, #{cityName}, #{description})")
    Long saveCity(City city);

    @Update("update city set province_id=#{provinceId}, city_name=#{cityName}, description=#{description} where id=#{id}")
    Long updateCity(City city);

    @Delete("delete from city where id=#{id}")
    Long deleteCity(Long id);

}
