import java.util.Scanner;

public class Filter {

    static Scanner scanner = new Scanner(System.in);


    public static void filterView() {

        System.out.println("""
                What bla bla do you want to filter, enter back to back?
                1.Category
                2.Price
                3.Quantity
                                
                """);

        System.out.print("Enter here >");
        String userInput = scanner.nextLine();

        switch (userInput) {
            case "1" -> filterCategory();
            case "2" -> filterPrice();
            case "3" -> filterQuantity();
            case "back" -> MenuUI.showMenu();
            default -> System.out.println("Wrong input!");
        }


    }

    public static void filterCategory() {
        System.out.println("What product category do want to see");
        String userInput = scanner.nextLine();

        Logic.productList.stream()
                .filter(product -> product.getCategory().equals(userInput))
                .forEach(filteredProduct -> System.out.println(filteredProduct));

    }

    public static void filterPrice() {
        System.out.println("Enter range");
        System.out.print("Min >");
        int inputMin = scanner.nextInt();
        System.out.print("Max >");
        int inputMax = scanner.nextInt();

        Logic.productList.stream()
                .filter(product -> product.getPrice() > inputMin && product.getPrice() < inputMax)
                .forEach(filteredProduct -> System.out.println(filteredProduct));

    }

    public static void filterQuantity(){
        System.out.println("Enter range");
        System.out.print("Min >");
        int inputMin = scanner.nextInt();
        System.out.print("Max >");
        int inputMax = scanner.nextInt();

        Logic.productList.stream()
                .filter(product -> product.getQuantity() >inputMin && product.getQuantity() <inputMax)
                .forEach(filteredProduct -> System.out.println(filteredProduct));

    }

}
