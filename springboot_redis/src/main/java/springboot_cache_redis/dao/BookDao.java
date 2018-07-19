package springboot_cache_redis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot_cache_redis.domain.Book;

public interface BookDao extends JpaRepository<Book, Long> {

}
