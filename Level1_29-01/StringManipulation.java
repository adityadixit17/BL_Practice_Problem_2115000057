import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int vowelCount = 0, consonantCount = 0;
        input = input.toLowerCase(); // Convert to lowercase for uniformity
        
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) { // Check if character is a letter
                if (isVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
 
        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    
        String reversed = reverseString(input);
        System.out.println("Reversed string: " + reversed);
        
        scanner.close();
    }
    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
    private static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int left = 0, right = str.length() - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        return new String(charArray);
    }
}

