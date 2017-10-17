package homework;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MainFrame {

    static String filePath;
    static String searchWords;

    public MainFrame(String filePath, String searchWords, String fileExtension) {

        MainFrame.filePath = filePath;
        MainFrame.searchWords = searchWords;
    }

    public static void main(String[] args) throws IOException {

        InvertedIndex invertedIndex = new InvertedIndex();
        Scanner userInput = new Scanner(System.in);
        String fileExtension = ".txt";


        try {
            System.out.print("Enter file path where documents are located: ");
            filePath = userInput.nextLine();
            invertedIndex.enterDirectoryPath(filePath, fileExtension);

            System.out.print("Enter search words: ");
            searchWords = userInput.nextLine();
            invertedIndex.search(Arrays.asList(searchWords.split(" ")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
