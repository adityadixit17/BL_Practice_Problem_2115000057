import java.util.*;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String str = "success";
        char mostFrequentChar = findMostFrequentCharacter(str);
        System.out.println("Most Frequent Character: '" + mostFrequentChar + "'");
    }

    public static char findMostFrequentCharacter(String str) {
        int[] frequency = new int[256];  // Array to store frequency of each character
        int maxCount = 0;
        char mostFrequentChar = '\0';
        
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            frequency[c]++;
            if (frequency[c] > maxCount) {
                maxCount = frequency[c];
                mostFrequentChar = c;
            }
        }
        
        return mostFrequentChar;
    }
}

