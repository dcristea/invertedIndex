package homework;

import java.io.*;
import java.util.*;

class InvertedIndex {

    Map<String, List<Tuple>> index = new HashMap<String, List<Tuple>>();
    List<String> files = new ArrayList<String>();


    public void enterDirectoryPath(String directory, String fileExtension) throws IOException {

        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();

        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile() && listOfFile.toString().contains(fileExtension)) {
                indexFile(listOfFile);
            }
        }
    }

    public void indexFile(File file) throws IOException {

        int fileNumber = files.indexOf(file.getPath());
        if (fileNumber == -1) {
            files.add(file.getPath());
            fileNumber = files.size() - 1;
        }

        int pos = 0;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            for (String _word : line.split("\\W+")) {
                String word = _word.toLowerCase();
                pos++;
                if (getStopWords().contains(word)) continue;
                List<Tuple> idx = index.get(word);
                if (idx == null) {
                    idx = new LinkedList<Tuple>();
                    index.put(word, idx);
                }
                idx.add(new Tuple(fileNumber, pos));
            }
        }
        System.out.println("indexed " + file.getPath() + " " + pos + " words");
    }

    public List getStopWords() throws FileNotFoundException {

        String fileName = "stopwords_en.txt";
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        ArrayList<String> listStopWords = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                listStopWords.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(listStopWords.toString());
        return listStopWords;
    }

    public void search(List<String> words) throws FileNotFoundException {
        for (String _word : words) {
            Set<String> answer = new HashSet<String>();
            String word = _word.toLowerCase();
            List<Tuple> idx = index.get(word);
            if (idx != null) {
                for (Tuple t : idx) {
                    answer.add(files.get(t.fileNumber));
                }
            }
            for (String f : answer) {
                System.out.print(word);
                System.out.println(" " + f);
            }
            if(answer.size() == 0) {
                System.out.println("Search words not found");
            }
            if(getStopWords().contains(word)) {
                System.out.println("The word is a stopword");
            }
            System.out.println("");
        }
    }

    private class Tuple {
        private int fileNumber;
        private int position;

        Tuple(int fileNumber, int position) {
            this.fileNumber = fileNumber;
            this.position = position;
        }
    }
}
