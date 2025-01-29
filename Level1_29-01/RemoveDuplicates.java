import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "programming";
        String result = removeDuplicates(input);
     
        System.out.println("Original string: " + input);
        System.out.println("String after removing duplicates: " + result);
    }
    
    public static String removeDuplicates(String str) {

        Set<Character> charSet = new LinkedHashSet<>();
       
        for (char c : str.toCharArray()) {
            charSet.add(c);
        }
        StringBuilder result = new StringBuilder();
        for (char c : charSet) {
            result.append(c);
        }
        return result.toString();
    }
}

