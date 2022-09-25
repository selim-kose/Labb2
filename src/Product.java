public class Product {

    private int id;

    private int quantity;
    private String name;
    private String brand;
    private String category;
    private double price;


    public Product() {

    }


    public Product(int id, int quantity, String name, String brand, String category, double price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String csvFormat() {
        return id + "," + quantity + "," + name + "," + brand + "," + category + "," + price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }


}
