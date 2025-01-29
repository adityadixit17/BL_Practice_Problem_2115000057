import java.util.*;

public class ToggleCase {
    public static void main(String[] args) {
        String str = "Hello World!";
        String result = toggleCase(str);
        System.out.println("Original string: " + str);
        System.out.println("Toggled string: " + result);
    }

    public static String toggleCase(String str) {
        StringBuilder toggledStr = new StringBuilder();
        
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) {
                toggledStr.append(Character.toLowerCase(c));
            } else if (Character.isLowerCase(c)) {
                toggledStr.append(Character.toUpperCase(c));
            } else {
                toggledStr.append(c);
            }
        }
        
        return toggledStr.toString();
    }
}

