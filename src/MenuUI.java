import java.sql.SQLOutput;
import java.util.Scanner;

public class MenuUI {

    public static void showMenu(){

    Scanner scanner = new Scanner(System.in);

    while(true){

        System.out.println("""
                
                #######################################
                Welcome, please choose an option below!
                #######################################
                
                1.Add a product to stock
                2.Remove a product from stock
                3.Update a product in stock
                4.Print all products in stock
                5.Create an order
                6.Filter
                
                e.Save and exit
                
                """);


        System.out.print("Enter here >");
        String userInput = scanner.nextLine();


        switch (userInput) {
            case "1" -> Logic.addProduct();
            case "2" -> Logic.removeProduct();
            case "3" -> Logic.updateProduct();
            case "4" -> Logic.printAllProducts();
            case "5" -> Order.createOrder();
            case "6" -> Filter.filterView();
            case "e" -> Logic.saveAndExit();
            default -> System.out.println("Wrong input, try again!");
        }
    }


    }


}
