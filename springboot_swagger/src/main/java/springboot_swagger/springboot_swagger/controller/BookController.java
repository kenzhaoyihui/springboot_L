package springboot_swagger.springboot_swagger.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springboot_swagger.springboot_swagger.entity.Book;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    /**
     * Create one book:  POST /books/
     * Modify one book:  PUT  /books/:id/
     * Delete ont book:  DELETE /books/:id/
     * Get all books:    GET   /books
     * Get ont book:     GET   /books/:id
     *
     * Swagger doc: http://swagger.io/docs/specification/api-host-and-base-path/
     */

    Map<Long, Book> books = Collections.synchronizedMap(new HashMap<Long, Book>());
    Book book1 = new Book(1L, "book1", 100.0);
    Book book2 = new Book(2L, "book2", 200.0);

    @ApiOperation(value = "Get Books List", notes = "Get Books List")
    @RequestMapping(value = {""}, method = RequestMethod.GET)
    public List<Book> getBooksList() {
        books.put(1L, book1);
        books.put(2L, book2);
        List<Book> book = new ArrayList<>(books.values());
        return book;
    }


    @ApiOperation(value = "Create book", notes = "Create Book")
    @ApiImplicitParam(name = "books", value = "Books Entity", required = true, dataType = "Book")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postBook(@RequestBody Book book) {
        try {
            books.put(book.getId(), book);
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @ApiOperation(value = "Get Book Info", notes = "Get Book Info from id")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBook(@PathVariable Long id) {
        return books.get(id);
    }

    @ApiOperation(value = "Update the Book", notes = "Update the Book Info")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path"),
            @ApiImplicitParam(name = "book", value = "book", required = true, dataType = "Book")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        Book book1 = books.get(id);
        try {
            book1.setName(book.getName());
            book1.setPrice(book.getPrice());

            books.put(id, book1);
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }


    @ApiOperation(value = "Delete Book", notes = "Delete Book")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long", paramType = "path")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") Long id) {
        try {
            books.remove(id);
        }catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

        return "success";
    }


    @ApiIgnore //Ignore this API
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String jsonTest() {
        return "Hello zyh!";
    }




}
