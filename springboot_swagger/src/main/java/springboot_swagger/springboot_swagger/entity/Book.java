package springboot_swagger.springboot_swagger.entity;

public class Book {

    private long id;
    private String name;
    private double price;

    public Book(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        //return super.toString();
        return "Book [" +
                " id=" + id +
                ", name=" + name +
                ", price=" + price +
                "]";
    }
}
