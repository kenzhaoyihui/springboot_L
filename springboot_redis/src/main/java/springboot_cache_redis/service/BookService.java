package springboot_cache_redis.service;

import springboot_cache_redis.domain.Book;

import java.util.List;

public interface BookService {

    /**
     * Get All Books
     * @return
     */
    List<Book> findAll();

    /**
     * Add Book
     * @param book {@link Book}
     * @return
     */
    Book insertByBook(Book book);

    /**
     * Update Book
     * @param book {@link Book}
     * @return
     */
    Book update(Book book);


    /**
     * Delete Book By Id
     * @param id
     * @return
     */
    Book delete(Long id);

    /**
     * Get Book By Id
     * @param id
     * @return
     */
    Book findById(Long id);
}
