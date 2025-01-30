import java.util.Scanner;

class VowelChecker {
    static boolean checkVowel(char ch) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char v : vowels) {
            if (ch == v) {
                return true;
            }
        }
        return false;
    }
}

public class VowelConsonantCounter {
    public void countVowelsConsonants(String str) {
        int vowelCount = 0, consonantCount = 0;
        char[] arr = str.toCharArray();
        
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                if (ch >= 'A' && ch <= 'Z') {
                    ch = (char) (ch + 32);
                }
                if (VowelChecker.checkVowel(ch)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }

        System.out.println("Number of vowels: " + vowelCount);
        System.out.println("Number of consonants: " + consonantCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VowelConsonantCounter counter = new VowelConsonantCounter();
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        counter.countVowelsConsonants(input);
        
    }
}

