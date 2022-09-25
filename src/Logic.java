import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> productList = new ArrayList<>();


    public static void addProduct() {

        while (true) {
            System.out.println("To add a product please give the following info, enter 'back' to go back");

            System.out.print("Name >");
            String inputName = scanner.nextLine();
            if (inputName.equals("back")) {
                break;
            }
            System.out.print("Brand >");
            String inputBrand = scanner.nextLine();
            System.out.print("Category >");
            String inputCategory = scanner.nextLine();
            System.out.print("Price >");
            int inputPrice = scanner.nextInt();
            scanner.nextLine();

            // IDCounter funkar ej, försök lös varför den inte tickar upp eller google en ID lösning på nätet

            int IDCounter = 0;
            IDCounter++;

            //Adderar angivna inputs till en productobjekt som sedan läggs in i en array
            productList.add(new Product(IDCounter, inputName, inputBrand, inputCategory, inputPrice));

        }

    }


    // metod för att ta port en produkt från listan. Användaren anger en String som går igenom listan.
    //vid träff tas den bort från ArrayList
    public static void removeProduct() {

        while (true) {

            System.out.println("What product do you want to remove, enter 'back' to go back?");
            String inputRemove = scanner.nextLine();

            if (inputRemove.equals("back")) {
                break;
            }

            for (Product i : productList) {
                if (i.getName().equals(inputRemove)) {
                    productList.remove(i);
                    System.out.println(inputRemove + " Was removed from the list");
                } else {
                    System.out.println("There is no product named " + inputRemove);
                }
            }
        }
    }

    public static void updateProduct() {
        System.out.println("What product do you want to update? Enter 'back to go back'");
        System.out.print(">");

        String inputChange = scanner.nextLine();

        if (inputChange.equals("back")) {
            MenuUI.showMenu();
        }


        System.out.println(productList.get(0));
        for (int i = 0; i < productList.size(); i++) {

            if (productList.get(i).getName().equals(inputChange)) {
                System.out.print("Name >");
                String inputName = scanner.nextLine();
                System.out.print("Brand >");
                String inputBrand = scanner.nextLine();
                System.out.print("Category >");
                String inputCategory = scanner.nextLine();
                System.out.print("Price >");
                int inputPrice = scanner.nextInt();
                scanner.nextLine();

                productList.set(i, new Product(0, inputName, inputBrand, inputCategory, inputPrice));
            }
        }
    }

    public static void printAllProducts() {
        if (!productList.isEmpty()) {
            for (Product i : productList) {
                System.out.println(i);
            }
        } else {
            System.out.println("\nStock is empty!");
            MenuUI.showMenu();
        }
    }

    public static void save() {
        try {

            FileWriter writer = new FileWriter("DataBase.txt", true);

            for (Product i : productList) {
                writer.write(i.csvFormat() + "\n");
            }
            writer.close();

        } catch (Exception e) {
            System.out.println("Error, did not find the database file " + e.getMessage());
        }
    }

    public static void saveAndExit() {
        save();
        System.exit(0);
    }
}
