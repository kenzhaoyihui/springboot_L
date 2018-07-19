package springboot_webflux_2_restful.restful.domain;

public class City {

    private Long id;

    private Long provinceId;

    private String cityName;

    private String description;

    public Long getId() {
        return id;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public String getCityName() {
        return cityName;
    }

    public String getDescription() {
        return description;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
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
