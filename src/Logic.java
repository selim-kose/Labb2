
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {
    static Scanner scanner = new Scanner(System.in);
    static List<Product> products = new ArrayList<>(); // listan där vi lagrar alla produkter


    //metod för att lägga till produkter
    public static void addProduct() {

        while (true) {
            System.out.println("\nTo add a new product please give the following info, enter 'back' to go back");

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

            System.out.println("\nWhat product do you want to remove, enter 'back' to go back?");
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


    //metod för att göra ändringar på befintliga produkter
    public static void updateProduct() {

        // skriver ut alla produkter i listan för att få en bättre överblick på vad man vill uppdatera
        System.out.println();
        printAllProducts();


        System.out.println("\nWhat product do you want to update? Enter 'back to go back'");
        System.out.print("Enter here >");

        String inputChange = scanner.nextLine();


        //Skriver man 'back' vid inmatning skickas man tillbaka till huvudmenyn
        if (inputChange.equals("back")) {
            MenuUI.showMenu();
        }



        for (int i = 0; i < products.size(); i++) {

            //går igenom produktlistan och kollar om man får en match på namnet användaren anger.
            //får man en träff får man ändra på produkten
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
        //ifall man inte får en träff kommer man hit och får veta att det inte finns en produkt med det namnet
        System.out.println();
        System.out.println(inputChange + " is not in stock!!!");
    }


    //printar alla produkter i listan

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


    //tar alla produkter som fins i produktlistan och skriver ner det i textfilen 'DataBase.txt' i CSV format.
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

