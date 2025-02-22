import java.util.regex.*;
public class ProgrammingLanguageExtractor {
    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        Pattern pattern = Pattern.compile("\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP)\\b");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted programming languages:");
        while (matcher.find()) System.out.print(matcher.group() + ", ");
    }
}
