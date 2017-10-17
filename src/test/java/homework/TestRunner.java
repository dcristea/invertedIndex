package homework;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import static homework.MainFrame.filePath;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TestRunner {

    InvertedIndex invertedIndex = new InvertedIndex();

    @Test
    public void checkFilePathIsADirectory() throws IOException {

        String expectedResult = "C:\\Work\\workspace\\homework\\src\\main\\resources\\documents";
        String actualResult = "C:\\Work\\workspace\\homework\\src\\main\\resources\\documents";
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

        String filePath = "C:\\Work\\workspace\\homework\\src\\main\\resources\\documents";
        String fileExtension = ".txt";
        invertedIndex.enterDirectoryPath(filePath, fileExtension);
        assertThat("File extension is .txt", fileExtension, is(".txt"));
    }

    @Test
    public void checkFileExtensionInvalidValue() throws IOException {

        String filePath = "C:\\Work\\workspace\\homework\\src\\main\\resources\\documents";
        String fileExtension = "3";
        invertedIndex.enterDirectoryPath(filePath, fileExtension);
        fail("File extension is not .txt");
    }

    @Test
    public void checkValidSearchWord() throws FileNotFoundException {

        String searchWords = "planet";
        invertedIndex.search(Arrays.asList(searchWords.split(" ")));
        assertThat("Search word(s) is(are) not valid",searchWords,is("planet"));
    }

    @Test
    public void checkStopWords() throws FileNotFoundException {

        String searchWords = "the";
        assertEquals("Search word is a stop word",true,invertedIndex.getStopWords().contains(searchWords));
    }

    @Test
    public void checkValidRegexSearchWord() throws FileNotFoundException {

        String searchWords = "planet evidence";
        String regex = " ";
        invertedIndex.search(Arrays.asList(searchWords.split(regex)));
        assertEquals("Valid regex is used",regex," ");
    }
}
