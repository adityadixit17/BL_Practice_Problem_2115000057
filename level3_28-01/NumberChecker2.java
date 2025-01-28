import java.util.Arrays;

public class NumberChecker2 {
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }
    public static int[] getDigitsArray(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }
    public static int[] reverseArray(int[] array) {
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length - 1 - i];
        }
        return reversed;
    }
    public static boolean areArraysEqual(int[] array1, int[] array2) {
        return Arrays.equals(array1, array2);
    }
    public static boolean isPalindrome(int number) {
        int[] digits = getDigitsArray(number);
        int[] reversed = reverseArray(digits);
        return areArraysEqual(digits, reversed);
    }
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigitsArray(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int number = 12321; // Example number
        System.out.println("Count of digits: " + countDigits(number));
        int[] digitsArray = getDigitsArray(number);
        System.out.println("Digits array: " + Arrays.toString(digitsArray));
        int[] reversedArray = reverseArray(digitsArray);
        System.out.println("Reversed digits array: " + Arrays.toString(reversedArray));
        System.out.println("Is the number a palindrome? " + isPalindrome(number));
        System.out.println("Is the number a duck number? " + isDuckNumber(number));
        int[] anotherArray = {1, 2, 3, 2, 1};
        System.out.println("Are the arrays equal? " + areArraysEqual(digitsArray, anotherArray));
    }
}
