package sprongboot_webflux_3_mongodb.sprongboot_webflux_3_mongodb.domain;

public class City {

    private Long id;

    private Long provinceId;

    private String cityName;

    private String description;

    public String getDescription() {
        return description;
    }

    public String getCityName() {
        return cityName;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public Long getId() {
        return id;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setId(Long id) {
        this.id = id;
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
