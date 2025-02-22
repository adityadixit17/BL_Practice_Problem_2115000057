import java.util.*;
import java.util.regex.*;
public class CapitalizedWordsExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted capitalized words:");
        while (matcher.find()) {
            System.out.print(matcher.group() + ", ");
        }     
    }
}
