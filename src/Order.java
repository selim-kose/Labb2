import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private static ArrayList<Product> order = new ArrayList<>();


    public Order() {

    }

    public static void createOrder() {
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("""
                    \n
                    ############################################
                    Choose products to your order by entering id
                    Enter '0' to checkout and get a receipt
                    ############################################\n
                     """);

            for (Product i : Logic.products) {
                System.out.println(i);
            }

            System.out.print("\nEnter here >");
            int userInputID = scanner.nextInt();


            if (userInputID == 0) {
                receipt();
                MenuUI.showMenu();
            }

            for (int i = 0; i < Logic.products.size(); i++) {
                if (userInputID == Logic.products.get(i).getId()) {
                    order.add(Logic.products.get(i));
                    Logic.products.get(i).setQuantity(Logic.products.get(i).getQuantity() - 1);
                    System.out.println(Logic.products.get(i).getName() + " was added to your order!");
                    createOrder();
                }

            }
            System.out.println("There is no product whit ID: '" + userInputID + "' , please try with another id.");

        }
    }

    public static void receipt() {
        double total = 0;

        for (int i = 0; i < order.size(); i++) {
            for (int j = 1; j < order.size(); j++) {
                if (order.get(i).equals(order.get(j))) {
                    order.get(i).setQuantity(order.get(i).getQuantity() + 1);
                }
            }
        }

        for (Product i : order) {
            System.out.println(i.getName() + " " + i.getPrice() + "Kr");
            total += i.getPrice();

        }
        System.out.println("\nTotal: " + total + " Kr");

    }
}
