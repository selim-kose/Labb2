import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private static List<Product> order = new ArrayList<>();
    public static double total;


    public Order() {

    }


    //metod som startat en order
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


            // printar produkterna så användaren kan välja vilka produkter som ska läggas till i ordern
            for (Product i : Logic.products) {
                System.out.println(i);
            }

            //ber användaren om ett ID
            System.out.print("\nEnter here >");
            int userInputID = scanner.nextInt();


            // om 0 anges får man ett kvitt på orden och men kommer till huvudmenyn igen
            if (userInputID == 0) {
                receipt();
                MenuUI.showMenu();
            }

            // Loop som går igenom listan med produkter och kollar om det finns en match med det id som använderen har angett
            //om det gör det läggs matchande produkt i en ny lista som heter order.
            //vi subtraherar sedan kvantiteten med 1 i produktlistan.
            //sedan ger vi en bekräftelse att att matchande produkt lades till i orden.
            //sedan går vi tillbaka till början av whileloopen.

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


    //Metod för att skapa ett kvitto
    public static void receipt() {
        total = 0; // håller koll på totalpriset


/*
        for (int i = 0; i < order.size(); i++) {
            for (int j = 1; j < order.size(); j++) {
                if (order.get(i).equals(order.get(j))) {
                    order.get(i).setQuantity(order.get(i).getQuantity() + 1);
                }
            }
        }*/

        // Skriver ut alla produkter i orderlistan men endast namn och pris
        for (Product i : order) {
            System.out.println(i.getName() + " " + i.getPrice() + "Kr");
            total += i.getPrice();

        }


        Product.setDiscount();
        System.out.println("\nTotal: " + total + " Kr"); // skriver ut totalpriset
        order.clear();

    }
}
