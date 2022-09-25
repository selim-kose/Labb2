public class Main {
    public static void main(String[] args) {
        ReadAndCreateFile.createFile("Database.txt");
        ReadAndCreateFile.readFile();
        System.out.println(ReadAndCreateFile.generateID());
        MenuUI.showMenu();

    }
}