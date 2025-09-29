package fit.iuh.beans;

public class Book {
    private Integer id;
    private String title;
    private int quantity;
    private double price;
    private String image;

    // Constructor
    public Book(Integer id, String title, int quantity, double price, String image) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    // Getter & Setter
    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    public String getImage() { return image; }
}