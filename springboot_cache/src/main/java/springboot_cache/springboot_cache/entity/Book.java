package springboot_cache.springboot_cache.entity;

public class Book {

    private String isbn;
    private String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Book [" +
                " ISBN=" + isbn +
                ", TITLE=" + title +
                "]";
    }
}
