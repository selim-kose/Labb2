import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class ReadAndCreateFile {

    public static void createFile(String filename) {
        try {

            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File successfully created!");

                FileWriter writer = new FileWriter(filename);

                ArrayList<Product> starterProducts = new ArrayList();

                starterProducts.add(new Product(1,12,"banan","chikita","frukt",5.0));
                starterProducts.add(new Product(2,5,"apelsin","maroc","frukt",7.0));
                starterProducts.add(new Product(3,3,"yes","svanen","rengöring",35.0));
                starterProducts.add(new Product(4,22,"snickers","mars","godis",10.0));
                starterProducts.add(new Product(5,10,"kalsong","gant","kläder",150.0));
                starterProducts.add(new Product(6,10,"tröja","nike","kläder",800.0));

                for (Product i: starterProducts){
                    writer.write(i.csvFormat()+ "\n");
                }
                writer.close();

            }
        } catch (IOException e) {
            System.out.println("Något gick fel " + e.getStackTrace());
        }
    }

    public static void readFile() {

        try {
            Files.lines(Paths.get("DataBase.txt"))
                    .map(line -> line.split(","))
                    .map(word -> new Product(Integer.valueOf(word[0]),Integer.valueOf(word[1]), word[2], word[3], word[4], Double.valueOf(word[5])))
                    .forEach(product -> Logic.products.add(product));

        } catch (IOException e) {
            System.out.println("kunde inte läsa filen" + e.getStackTrace());
        }

        for (Product i : Logic.products) {
            System.out.println(i);
        }
    }

    public static int generateID(){
        int lastID = Logic.products.size()+1;
        if(Logic.products.isEmpty()){
            return 1;
        }
        return lastID;
    }


}
