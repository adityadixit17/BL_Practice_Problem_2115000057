import java.util.Scanner;

public class AnagramChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        String str1 = scanner.nextLine();

        System.out.print("Enter the second string: ");
        String str2 = scanner.nextLine();

        boolean isAnagram = areAnagrams(str1, str2);

        if (isAnagram) {
            System.out.println("The two strings are anagrams.");
        } else {
            System.out.println("The two strings are not anagrams.");
        }

        scanner.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        sortArray(charArray1);
        sortArray(charArray2);

        for (int i = 0; i < charArray1.length; i++) {
            if (charArray1[i] != charArray2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void sortArray(char[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}

