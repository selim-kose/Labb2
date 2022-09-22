import java.util.ArrayList;
import java.util.Scanner;

public class Logic {

static Scanner scanner = new Scanner(System.in);
static ArrayList<Product> productList = new ArrayList<>();

    public static void addProduct(){



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


        int IDCounter=0;


        productList.add(new Product(IDCounter,inputName,inputBrand,inputCategory,inputPrice));
        IDCounter += IDCounter;


    }

    public static void removeProduct() {
        System.out.println("");
    }

    public static void printAllProducts() {
        for(Product i : productList){
            System.out.println(i);
        }
    }



}
