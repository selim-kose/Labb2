import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuUI {

    public static void showMenu(){

    Scanner scanner = new Scanner(System.in);

    while(true){

        System.out.println("""
                
                Welcome, please choose an option!
                
                1.Add a product to stock
                2.Remove product from stock
                3.Print all products in stock
                5.Create an order
                4.Save
                
                e.Save and exit
                
                """);


        System.out.print(">");
        String userInput = scanner.nextLine();


        switch (userInput) {
            case "1" -> Logic.addProduct();
            case "2" -> Logic.removeProduct();
            case "3" -> Logic.printAllProducts();
            case "4" -> Logic.save();
            case "e" -> Logic.saveAndExit();
            default -> System.out.println("Wrong input, try again!");
        }
    }


    }


}
