package springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.domain;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

//加上了@Document注解之后，默认情况下这个实体中所有的属性都会被建立索引、并且分词。
@Document(indexName = "province", type = "city")
public class City implements Serializable {

    private static final long serialVersionUID = -1L;

    private Long id;

    private String name;

    private String description;

    private Integer score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    @Override
    public String toString() {
        //return super.toString();
        return "City [" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", score=" + score +
                "]";
    }
}
