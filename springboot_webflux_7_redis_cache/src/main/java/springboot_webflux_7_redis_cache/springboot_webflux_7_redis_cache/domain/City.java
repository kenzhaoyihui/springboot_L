package springboot_webflux_7_redis_cache.springboot_webflux_7_redis_cache.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class City implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private Long id;

    private Long provinceId;

    private String cityName;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "City [" +
                "id=" + id +
                ", provinceId=" + provinceId +
                ", cityName=" + cityName +
                ", description=" + description +
                "]";
    }
}
