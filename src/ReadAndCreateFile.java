import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class ReadAndCreateFile {

    public static void createFile(String filename) {
        try {

            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
                System.out.println("File successfully created!");
            }
        } catch (IOException e) {
            System.out.println("Något gick fel " + e.getStackTrace());
        }
    }

    public static void readFile() {

        try {
            Files.lines(Paths.get("DataBase.txt"))
                    .map(line -> line.split(","))
                    .map(word -> new Product(Integer.valueOf(word[0]), word[1], word[2], word[3], Double.valueOf(word[4])))
                    .forEach(product -> Logic.productList.add(product));

        } catch (IOException e) {
            System.out.println("kunde inte läsa filen" + e.getStackTrace());
        }

        for (Product i : Logic.productList) {
            System.out.println(i);
        }

    }


}
