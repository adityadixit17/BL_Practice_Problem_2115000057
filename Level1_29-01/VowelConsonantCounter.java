import java.util.Scanner;

public class VowelConsonantCounter {
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
        
        scanner.close();
    }
   
    private static boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}

