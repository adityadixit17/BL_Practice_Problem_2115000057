import java.io.*;
import java.util.*;

public class WordfrequencyCounter {
    public static Map<String, Integer> countWordFrequency(String filePath) throws IOException {
        Map<String, Integer> wordCount = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }
        reader.close();
        return wordCount;
    }

    public static void main(String[] args) throws IOException {
        String filePath = "input.txt";
        System.out.println(countWordFrequency(filePath));
    }
}
