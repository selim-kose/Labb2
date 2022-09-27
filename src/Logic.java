
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct() {

        while (true) {
            System.out.println("To add a new product please give the following info, enter 'back' to go back");

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

            //Adderar angivna inputs till en productobjekt som sedan läggs in i en array
            System.out.println(inputName + " added to list");
            products.add(new Product(ReadAndCreateFile.generateID(), 1, inputName, inputBrand, inputCategory, inputPrice));

        }
    }


    // metod för att ta port en produkt från listan. Användaren anger en String som går igenom listan.
    //vid träff tas den bort från ArrayList
    public static void removeProduct() {

        while (true) {

            System.out.println("What product do you want to remove, enter 'back' to go back?");
            System.out.print("\nEnter here >");
            String inputRemove = scanner.nextLine();

            if (inputRemove.equals("back")) {
                break;
            }

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getName().equals(inputRemove)) {
                    System.out.println("\n" + products.get(i).getName() + " was removed from stock!\n");
                    products.remove(i);
                    break;
                }

            }
            System.out.println("\nThere is no product named " + inputRemove);
        }
    }

    public static void updateProduct() {


        System.out.println("What product do you want to update? Enter 'back to go back'");
        System.out.print("Enter here >");

        String inputChange = scanner.nextLine();

        if (inputChange.equals("back")) {
            MenuUI.showMenu();
        }

        for (int i = 0; i < products.size(); i++) {

            if (products.get(i).getName().equals(inputChange)) {
                System.out.print("ID >");
                int inputID = scanner.nextInt();
                System.out.print("Quantity >");
                int inputQuantity = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Name >");
                String inputName = scanner.nextLine();
                System.out.print("Brand >");
                String inputBrand = scanner.nextLine();
                System.out.print("Category >");
                String inputCategory = scanner.nextLine();
                System.out.print("Price >");
                int inputPrice = scanner.nextInt();
                scanner.nextLine();

                products.set(i, new Product(inputID, inputQuantity, inputName, inputBrand, inputCategory, inputPrice));
                break;
            }

        }
        System.out.println(inputChange + " is not in stock");
    }

    public static void printAllProducts() {
        if (!products.isEmpty()) {
            for (Product i : products) {
                System.out.println(i);
            }
        } else {
            System.out.println("\nStock is empty!");
            MenuUI.showMenu();
        }
    }

    public static void save() {
        try {

            FileWriter writer = new FileWriter("DataBase.txt");

            for (Product i : products) {
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

