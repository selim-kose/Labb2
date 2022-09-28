import java.util.Scanner;

public class Filter {

    static Scanner scanner = new Scanner(System.in);



    //Filter menyn där användaren väljer vad som ska filtreras
    public static void filterView() {

        System.out.println();
        System.out.println("""
                What do you want to filter, enter back to back?
                1.Category
                2.Price
                3.Quantity
                                
                """);

        //Läser inte använderans val
        System.out.print("Enter here >");
        String userInput = scanner.nextLine();


        //Beroende på vad användaren väljer i steget innan kallas rätt filtermetod
        switch (userInput) {
            case "1" -> filterCategory();
            case "2" -> filterPrice();
            case "3" -> filterQuantity();
            case "back" -> MenuUI.showMenu();
            default -> System.out.println("Wrong input!");
        }


    }


    //Filtrerar ArrayListen products där producterna är sparade. Använderen väljer vilken kategori som ska visas
    //som filtreras med en stream.
    public static void filterCategory() {
        System.out.println("What product category do want to see");
        String userInput = scanner.nextLine();

        Logic.products.stream()
                .filter(product -> product.getCategory().equals(userInput))
                .forEach(filteredProduct -> System.out.println(filteredProduct));

    }
    //Filtrerar ArrayListen products där producterna är sparade. Använderen väljer vilken pris som ska visas
    //som filtreras med en stream.
    public static void filterPrice() {
        System.out.println("Enter range");
        System.out.print("Min >");
        int inputMin = scanner.nextInt();
        System.out.print("Max >");
        int inputMax = scanner.nextInt();

        Logic.products.stream()
                .filter(product -> product.getPrice() > inputMin && product.getPrice() < inputMax)
                .forEach(filteredProduct -> System.out.println(filteredProduct));

    }


    //Filtrerar ArrayListen products där producterna är sparade. Använderen väljer vilka produkter som ska
    // visas efter antal produkter.
    //som filtreras med en stream.
    public static void filterQuantity(){
        System.out.println("Enter range");
        System.out.print("Min >");
        int inputMin = scanner.nextInt();
        System.out.print("Max >");
        int inputMax = scanner.nextInt();

        Logic.products.stream()
                .filter(product -> product.getQuantity() >inputMin && product.getQuantity() <inputMax)
                .forEach(filteredProduct -> System.out.println(filteredProduct));

    }

}
