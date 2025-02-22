import java.util.regex.*;
public class LinkExtractor {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        Pattern pattern = Pattern.compile("\\bhttps?://[\\w.-]+\\.[a-z]{2,}\\b");
        Matcher matcher = pattern.matcher(text);
        System.out.println("Extracted links:");
        while (matcher.find()) System.out.print(matcher.group() + ", ");
    }
}
