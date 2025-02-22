import java.util.regex.*;
public class SSNValidator {
    public static boolean isValidSSN(String ssn) {
        return ssn.matches("^\\d{3}-\\d{2}-\\d{4}$");
    }
    public static void main(String[] args) {
        String ssn = "123-45-6789";
        System.out.println(isValidSSN(ssn) ?" \"" + ssn + "\" is valid" : " \"" + ssn + "\" is invalid");
    }
}
