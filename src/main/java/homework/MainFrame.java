package homework;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainFrame {

    static String filePath;
    static String searchWords;

    public MainFrame(String filePath, String searchWords) {

        MainFrame.filePath = filePath;
        MainFrame.searchWords = searchWords;
    }

    public static void main(String[] args) throws IOException {

        InvertedIndex invertedIndex = new InvertedIndex();
        Scanner userInput = new Scanner(System.in);


        try {
            System.out.print("Enter file path where documents are located: ");
            filePath = userInput.nextLine();

            File folder = new File(filePath);
            File[] listOfFiles = folder.listFiles();

            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile() && listOfFile.toString().contains(".txt")) {
                    invertedIndex.indexFile(listOfFile);
                } else if (listOfFile.isDirectory()) {
                    System.out.println(listOfFile.getName() + " is a Directory");
                    System.exit(0);
                }
            }

            System.out.print("Enter search words: ");
            searchWords = userInput.nextLine();
            invertedIndex.search(Arrays.asList(searchWords.split(" ")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
