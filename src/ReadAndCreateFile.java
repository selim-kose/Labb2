import java.io.File;
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
            }
        } catch (IOException e) {
            System.out.println("Något gick fel " + e.getStackTrace());
        }
    }

    public static void readFile() {
        ArrayList<Product> tempList = new ArrayList<>();

        try {
            Files.lines(Paths.get("DataBase.txt"))
                    .map(line -> line.split(","))
                    .map(word -> new Product(Integer.valueOf(word[0]), word[1], word[2], word[3], Double.valueOf(word[4])))
                    .forEach(product -> tempList.add(product));

        } catch (Exception e) {
            System.out.println("kunde inte läsa filen" + e.getMessage());
        }

        for (Product i : tempList) {
            System.out.println(i);
        }

    }
}
