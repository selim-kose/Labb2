import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadAndCreateFile {


    //metod för att skapa textfilen där vi kommer skriva ner produktlistan
    public static void createFile(String filename) {

        //try/catch block för att fånga ev fel som uppstår
        try {

            //Skapar en filvariabel med namnet som anges i metodens parameter
            File file = new File(filename);

            //kollar om filen existerar, om inte skapar filen
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File successfully created!"); // ger en bekräftelse att filen skapades

                // skapar en Filewriter för att vi sedan ska kunna skriva i filen vi skapade ovan
                FileWriter writer = new FileWriter(filename);


                // En ny lista skapas där vi sedan lägger in några produkter från start så vi slipper göra det när
                //textfilen är tom
                List<Product> starterProducts = new ArrayList<>();

                starterProducts.add(new Product(1, 12, "banan", "chikita", "frukt", 5.0));
                starterProducts.add(new Product(2, 5, "apelsin", "maroc", "frukt", 7.0));
                starterProducts.add(new Product(3, 3, "yes", "svanen", "rengöring", 35.0));
                starterProducts.add(new Product(4, 22, "snickers", "mars", "godis", 10.0));
                starterProducts.add(new Product(5, 10, "kalsong", "gant", "kläder", 150.0));
                starterProducts.add(new Product(6, 10, "tröja", "nike", "kläder", 800.0));


                // skriver ner samtliga produkter i listan i CSV format.
                for (Product i : starterProducts) {
                    writer.write(i.csvFormat() + "\n");
                }

                //Stänger ner FileWritern så allt sparas
                writer.close();

            }
        } catch (IOException e) {
            System.out.println("Något gick fel " + e.getStackTrace()); //
        }
    }


    //metod för att läsa textfilen som lagrar produkterna och för över produkterna till en lista

    public static void readFile() {

        try {
            /**
             * Skapar en stream med filen 'DataBase.txt' som lagrar produkter i csv format.
             * Sedan mappar vi om linjerna i filen genom att dela de där ',' tecknet är.
             * Sedan skapar vi en ny instance av Product med de värden vi får
             * sedan lägger vi in produkterna i en lista
             */
            Files.lines(Paths.get("DataBase.txt"))
                    .map(line -> line.split(","))
                    .map(word -> new Product(Integer.valueOf(word[0]), Integer.valueOf(word[1]), word[2], word[3], word[4], Double.valueOf(word[5])))
                    .forEach(product -> Logic.products.add(product));

        } catch (IOException e) {
            System.out.println("kunde inte läsa filen" + e.getStackTrace());
        }

        //Skriver ut alla produkter i början vid start av program OBS! för felsökningssyfte
//        for (Product i : Logic.products) {
//            System.out.println(i);
//        }
    }

    //Generar id. Kallar på metoden när en ny produkt skapas

    public static int generateID() {
        int lastID = Logic.products.size() + 1;
        if (Logic.products.isEmpty()) {
            return 1;
        }
        return lastID;
    }


}
