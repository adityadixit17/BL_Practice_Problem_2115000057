import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        String cleanedInput = cleanString(input);
        if (isPalindrome(cleanedInput)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
        
        scanner.close();
    }

    private static String cleanString(String str) {
        char[] temp = new char[1000];
        int n = 0;

        while (true) {
            try {
                char ch = str.charAt(n);
                if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
                    if (ch >= 'A' && ch <= 'Z') {
                        ch = (char) (ch + 32);
                    }
                    temp[n] = ch;
                }
                n++;
            } catch (Exception e) {
                break;
            }
        }

        String cleaned = "";
        for (int i = 0; i < n; i++) {
            if (temp[i] != '\0') {
                cleaned += temp[i];
            }
        }
        return cleaned;
    }

    private static boolean isPalindrome(String str) {
        char[] charArray = str.toCharArray();
        int n = 0;

        while (true) {
            try {
                char temp = charArray[n];
                n++;
            } catch (Exception e) {
                break;
            }
        }

        int left = 0, right = n - 1;
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

