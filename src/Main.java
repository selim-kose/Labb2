import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ReadFile.readFile();
        MenuUI.showMenu();

        /*

        Product banana = new Fruit(0,"Banana","Chicita", "Fruit", 1.5,"Yellow","Sweet");

        System.out.println(banana);



        HashMap<String,Product> stock= new HashMap<>();

        stock.put(banana.getCategory(),(Fruit)banana);
        System.out.println(stock.get("Fruit"));
*/
    }
}