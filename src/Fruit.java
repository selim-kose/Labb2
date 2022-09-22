public class Fruit extends Product {

    private String color;
    private String taste;


    public Fruit(int id, String name, String brand, String category, double price, String color, String taste) {
        super(id, name, brand, category, price);
        this.color = color;
        this.taste = taste;

    }

    @Override
    public String toString() {
        return "Fruit{" +
                "color='" + color + '\'' +
                ", taste='" + taste + '\'' +
                '}';
    }
}
