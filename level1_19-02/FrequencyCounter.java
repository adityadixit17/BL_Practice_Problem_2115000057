
import java.util.*;

public class FrequencyCounter {
    public static Map<String, Integer> countFrequency(List<String> words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(input);
        System.out.println(result); 
    }
}

