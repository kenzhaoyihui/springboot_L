package springbootelasticsearchquery2.springbootelasticsearchquery2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springbootelasticsearchquery2.springbootelasticsearchquery2.domain.City;

import java.util.List;

public interface CityRepository extends ElasticsearchRepository<City, Long> {

    /**
     * AND
     *
     * @param description
     * @param score
     * @return
     */
    List<City> findByDescriptionAndScore(String description, Integer score);


    /**
     * Or
     *
     * @param description
     * @param score
     * @return
     */
    List<City> findByDescriptionOrScore(String description, Integer score);


    /**
     *
     * The same as:
     * @Query("{\"bool\" : {\"must\" : {\"term\" : {\"description\" : \"?0\"}}}}")
     * Page<City> findByDescription(String description, Pageable pageable);
     *
     * @param description
     * @param page
     * @return
     */
    Page<City> findByDescription(String description, Pageable page);


    /**
     * NOT
     *
     * @param description
     * @param page
     * @return
     */
    Page<City> findByDescriptionNot(String description, Pageable page);

    /**
     * LIKE
     *
     * @param description
     * @param page
     * @return
     */
    Page<City> findByDescriptionLike(String description, Pageable page);
}

