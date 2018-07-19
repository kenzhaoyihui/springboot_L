package springboot_cache_redis.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String writer;

    private String introduction;

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Book [" +
                " id=" + id +
                ", name=" + name +
                ", writer=" + writer +
                ", introduction=" + introduction +
                "]";
    }
}
