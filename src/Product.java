import java.util.Objects;

public class Product {

    private int id;

    private int quantity;
    private String name;
    private String brand;
    private String category;
    private double price;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && quantity == product.quantity && Double.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(brand, product.brand) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, name, brand, category, price);
    }

    public static void setDiscount(){
        if(Order.total >=1000.0 && Order.total <= 1999.9) {
            Order.total = Order.total * 0.9;
            System.out.println("Discount 10%");
        }else if(Order.total >=2000.0 && Order.total <=2999.9) {
            Order.total = Order.total * 0.8;
            System.out.println("Discount 20%");
        }else if (Order.total >=3000.0 && Order.total <= 3999.9) {
            Order.total = Order.total * 0.7;
            System.out.println("Discount 30%");
        }else if(Order.total >4000){
            Order.total = Order.total * 0.6;
            System.out.println("Discount 40%");

        }



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
