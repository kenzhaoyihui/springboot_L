package springboot_freemarker.springboot_freemarker.domain;

/**
 * City Pojo
 */
public class City {

    /**
     * city id
     */
    private Long id;


    /**
     * province id
     */
    private Long provinceId;


    /**
     * City name
     */
    private String cityName;


    /**
     * description
     */
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
