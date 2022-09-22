import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuUI {

    public static void showMenu(){

    Scanner scanner = new Scanner(System.in);

    while(true){

        System.out.println("""
                
                Welcome, please choose an option!
                
                1.Add a product
                2.Remove product
                3.Print all products
                4.Save
                
                e.Save and exit
                
                """);


        System.out.print(">");
        String userInput = scanner.nextLine();



        switch (userInput) {
            case "1": Logic.addProduct();
                break;
            case "2":
                break;
            case "3":Logic.printAllProducts();
                break;
            case "e":
                break;
            default:System.out.println("Wrong input, try again!");

        }
    }


    }


}
