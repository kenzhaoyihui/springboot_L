package springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import springboot_data_elasticsearch_query.springboot_data_eleasticsearch_query.domain.City;

public interface CityRepository extends ElasticsearchRepository<City, Long> {
}
