import java.util.ArrayList;
import java.util.List;

public class NumberChecker {

    public static void main(String[] args) {
        int number = 153;

        System.out.println("Number: " + number);
        System.out.println("Count of digits: " + countDigits(number));

        int[] digits = getDigits(number);
        System.out.println("Digits: ");
        for (int digit : digits) {
            System.out.print(digit + " ");
        }
        System.out.println();

        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));

        int[][] digitFrequency = findDigitFrequency(number);
        System.out.println("Digit frequencies:");
        for (int[] pair : digitFrequency) {
            System.out.println("Digit " + pair[0] + ": " + pair[1] + " times");
        }
    }

    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static int[] getDigits(int number) {
        List<Integer> digitsList = new ArrayList<>();
        while (number != 0) {
            digitsList.add(0, number % 10);
            number /= 10;
        }
        return digitsList.stream().mapToInt(i -> i).toArray();
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    public static int[][] findDigitFrequency(int number) {
        int[] frequency = new int[10]; // To store frequencies of digits 0-9
        while (number != 0) {
            frequency[number % 10]++;
            number /= 10;
        }
        // Prepare the 2D array with digit and its frequency
        List<int[]> freqList = new ArrayList<>();
        for (int digit = 0; digit < 10; digit++) {
            if (frequency[digit] > 0) {
                freqList.add(new int[]{digit, frequency[digit]});
            }
        }
        return freqList.toArray(new int[0][]);
    }
}
