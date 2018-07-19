package springboot_cache_redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import springboot_cache_redis.domain.Book;
import springboot_cache_redis.service.BookService;

//@RestController
@Controller
@RequestMapping(value = "/book")
public class BookController {

    private static final String BOOK_FORM_PATH_NAME = "bookForm";
    private static final String BOOK_LIST_PATH_NAME = "bookList";
    private static final String REDIRECT_TO_BOOK_URL = "redirect:/book";

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String getBookList(ModelMap map) {
        map.addAttribute("bookList", bookService.findAll());
        return BOOK_LIST_PATH_NAME;
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createBookForm(ModelMap map) {
        map.addAttribute("book", new Book());
        map.addAttribute("action", "create");
        return BOOK_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postBook(@ModelAttribute Book book) {
        bookService.insertByBook(book);
        return REDIRECT_TO_BOOK_URL;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getUser(@PathVariable("id") Long id, ModelMap map) {
        map.addAttribute("book", bookService.findById(id));
        map.addAttribute("action", "update");
        return BOOK_FORM_PATH_NAME;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putBook(@ModelAttribute Book book) {
        bookService.update(book);
        return REDIRECT_TO_BOOK_URL;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
        return REDIRECT_TO_BOOK_URL;
    }


}
