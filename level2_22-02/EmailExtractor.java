import java.util.*;
import java.util.regex.*;
public class EmailExtractor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted email addresses:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }        
    }
}
