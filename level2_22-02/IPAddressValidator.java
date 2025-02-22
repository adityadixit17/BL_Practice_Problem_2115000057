import java.util.regex.*;
public class IPAddressValidator {
    public static boolean isValidIPAddress(String ip) {
        String regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        return ip.matches(regex);
    }
    public static void main(String[] args) {
        String ip = "192.168.1.1";
        System.out.println(isValidIPAddress(ip) ? "Valid IP Address" : "Invalid IP Address");
    }
}
