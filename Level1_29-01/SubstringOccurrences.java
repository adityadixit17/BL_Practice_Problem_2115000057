import java.util.*;

public class SubstringOccurrences {
    public static void main(String[] args) {
        String str = "hello world, hello everyone, hello universe";
        String substring = "hello";
        int count = countSubstringOccurrences(str, substring);
        System.out.println("The substring '" + substring + "' appears " + count + " times.");
    }

    public static int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }

        return count;
    }
}

