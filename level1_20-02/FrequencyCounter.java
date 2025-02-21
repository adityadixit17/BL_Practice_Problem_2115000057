import java.io.*;  
import java.util.*;  
public class FrequencyCounter {  
public static void main(String[] args) {  
Map<String, Integer> wordCount = new HashMap<>();  
try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {  
String line;  
while ((line = br.readLine()) != null) {  
String[] words = line.toLowerCase().replaceAll("[^a-z ]", "").split("\\s+");  
for (String word : words) {  
if (!word.isEmpty())  
wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);  
}  
}  
} catch (IOException e) {  
System.out.println(e.getMessage());  
}  
List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(wordCount.entrySet());  
sortedList.sort((a, b) -> b.getValue().compareTo(a.getValue()));  
for (int i = 0; i < Math.min(5, sortedList.size()); i++)  
System.out.println(sortedList.get(i).getKey() + ": " + sortedList.get(i).getValue());  
}  
}  
