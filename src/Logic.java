import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> productList = new ArrayList<>();

    public static void addProduct() {


        System.out.println("To add a product please give the following info");

        System.out.print("Name >");
        String inputName = scanner.nextLine();
        System.out.print("Brand >");
        String inputBrand = scanner.nextLine();
        System.out.print("Category >");
        String inputCategory = scanner.nextLine();
        System.out.print("Price >");
        int inputPrice = scanner.nextInt();
        scanner.nextLine();

        // IDCounter funkar ej, försök lös varför den inte tickar upp eller google en ID lösning på nätet
        int IDCounter = 0;

        //Adderar angivna inputs till en productobjekt som sedan läggs in i en array
        productList.add(new Product(IDCounter, inputName, inputBrand, inputCategory, inputPrice));
        IDCounter += IDCounter;


    }


    // metod för att ta port en produkt från listan. Användaren anger en String som går igenom listan.
    //vid träff tas den bort från ArrayList
    public static void removeProduct() {
        System.out.println("What product do you want to remove?");
        String inputRemove = scanner.nextLine();

        for (Product i : productList) {
            if (i.getName().equals(inputRemove)) {
                productList.remove(i);
                System.out.println(inputRemove + " Was removed from the list");
            } else {
                System.out.println("There is no product named " + inputRemove);
            }
        }
    }

    public static void printAllProducts() {
        for (Product i : productList) {
            System.out.println(i);
        }
    }

    public static void save() {
        try {
            PrintWriter writer = new PrintWriter("DataBase.txt");

            for (Product i : productList) {
                writer.println(i.csvFormat());
                writer.close();
            }

            // Files.lines(Paths.get("DataBase.txt"));

        } catch (Exception e) {
            System.out.println("Error, did not find the database file " + e.getMessage());
        }

    }

    public static void saveAndExit() {
        save();
        System.exit(0);
    }


}
