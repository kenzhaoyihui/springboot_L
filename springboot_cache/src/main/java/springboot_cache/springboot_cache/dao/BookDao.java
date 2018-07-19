package springboot_cache.springboot_cache.dao;

import springboot_cache.springboot_cache.entity.Book;

public interface BookDao {

    Book getByIsbn(String isbn);

    Book getByTitle(String title);
}
