package springboot_async.springboot_async.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String name;
    private String blog;
    private String company;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getBlog() {
        return blog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "User [" +
                "id=" + id +
                ", name=" + name +
                ", blog=" + blog +
                ", company=" + company +
                "]";
    }
}
