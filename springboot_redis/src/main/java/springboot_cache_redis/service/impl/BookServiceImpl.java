package springboot_cache_redis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import springboot_cache_redis.dao.BookDao;
import springboot_cache_redis.domain.Book;
import springboot_cache_redis.service.BookService;

import java.util.List;

@Service
@CacheConfig(cacheNames = "books")
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> findAll() {
        //return null;
        return bookDao.findAll();
    }


    @Cacheable("#p0")
    @Override
    public Book findById(Long id) {
        //return null;
        System.out.println("Call findById method...");
        return bookDao.findById(id).get();
    }


    @Override
    public Book insertByBook(Book book) {
        //return null;
        return bookDao.save(book);
    }

    @CachePut(key = "#p0.id")
    @Override
    public Book update(Book book) {
        //return null;
        System.out.println("Call update method...");
        return bookDao.save(book);
    }


    @CacheEvict(key = "#p0")
    @Override
    public Book delete(Long id) {
        System.out.println("Call delete method...");
        //return null;
        Book book = bookDao.findById(id).get();
        bookDao.delete(book);
        return book;
    }
}
