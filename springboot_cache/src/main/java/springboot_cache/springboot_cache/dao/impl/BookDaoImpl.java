package springboot_cache.springboot_cache.dao.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import springboot_cache.springboot_cache.dao.BookDao;
import springboot_cache.springboot_cache.entity.Book;

@Repository
public class BookDaoImpl implements BookDao {

    @Override
    @Cacheable("books")    // define the cache name
    public Book getByIsbn(String isbn) {

        //return null;
        simulateSlowService();
        return new Book(isbn, "Love");
    }

    @Override
    public Book getByTitle(String title) {
        //return null;
        simulateSlowService();
        return new Book("1234", title);
    }


    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        }catch (InterruptedException e) {
            //e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }
}
