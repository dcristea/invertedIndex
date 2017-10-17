package homework;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static homework.MainFrame.filePath;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestRunner {

    InvertedIndex invertedIndex = new InvertedIndex();


    public File getResource(String resourceName) {

        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(resourceName).getFile());
    }

    public void mainExecution(String fileExtension,String filePath,String searchWords,String regex) throws IOException {

        InvertedIndex invertedIndex = new InvertedIndex();
        invertedIndex.enterDirectoryPath(filePath, fileExtension);
        invertedIndex.search(Arrays.asList(searchWords.split(regex)));

    }

    @Test
    public void checkFilePathIsADirectory() throws IOException {

        String expectedResult = String.valueOf(getResource("documents"));
        String actualResult = String.valueOf(getResource("documents"));
        System.out.println(expectedResult);
        invertedIndex.enterDirectoryPath(actualResult, ".txt");
        assertEquals("The file path is not a directory", expectedResult, actualResult);
    }

    @Test
    public void checkFilePathIsNotEmpty() throws IOException {

        filePath = "";
        invertedIndex.enterDirectoryPath(filePath, ".txt");
        fail("File path is empty");
    }

    @Test
    public void checkFileExtensionIsTxt() throws IOException {

        String filePath = String.valueOf(getResource("documents"));
        String fileExtension = ".txt";
        invertedIndex.enterDirectoryPath(filePath, fileExtension);
        assertThat("File extension is .txt", fileExtension, is(".txt"));
    }

    @Test
    public void checkFileExtensionInvalidValue() throws IOException {

        String filePath = String.valueOf(getResource("documents"));
        String fileExtension = "3";
        invertedIndex.enterDirectoryPath(filePath, fileExtension);
        fail("File extension is not .txt");
    }

    @Test
    public void checkValidSearchWord() throws FileNotFoundException {

        String searchWords = "planet";
        invertedIndex.search(Arrays.asList(searchWords.split(" ")));
        assertThat("Search word(s) is(are) not valid", searchWords, is("planet"));
    }

    @Test
    public void checkStopWords() throws FileNotFoundException {

        String searchWords = "the";
        assertEquals("Search word is a stop word", true, invertedIndex.getStopWords().contains(searchWords));
    }

    @Test
    public void checkValidRegexSearchWord() throws FileNotFoundException {

        String searchWords = "planet evidence";
        String regex = " ";
        invertedIndex.search(Arrays.asList(searchWords.split(regex)));
        assertEquals("Valid regex is used", regex, " ");
    }
}
