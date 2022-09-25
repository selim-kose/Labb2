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

            for (Product i : Logic.productList) {
                System.out.println(i);
            }

            System.out.print("\nEnter here >");
            int userInputID = scanner.nextInt();
            System.out.println("\n");

            if (userInputID == 0) {
                receipt();
            }


            for (Product j : Logic.productList) {
                if (userInputID == j.getId()) {
                    order.add(j);
                    System.out.println(j.getName() + " was added to your order!");
                    break;
                }

            }
            System.out.println("There is no product whit ID: '" + userInputID + "' , please try with another id.");
        }

    }


    public static void receipt() {
        double total = 0;

        for (Product i : order) {
            System.out.println(i.getName() + " " + i.getPrice() + "Kr");
            total += i.getPrice();

        }
        System.out.println("\nTotal: " + total + " Kr");

    }
}
