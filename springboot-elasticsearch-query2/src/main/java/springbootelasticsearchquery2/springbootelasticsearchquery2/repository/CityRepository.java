package springbootelasticsearchquery2.springbootelasticsearchquery2.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import springbootelasticsearchquery2.springbootelasticsearchquery2.domain.City;

public interface CityRepository extends ElasticsearchRepository<City, Long> {
}
