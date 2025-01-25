import java.util.*;
public class ques10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int[] frequency = new int[10];
        int[] digits = new int[10];
        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            frequency[digits[index]]++;
            number /= 10;
            index++;
        }
        System.out.println("\nFrequency of each digit in the number:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s).");
            }
        }
    }
}
