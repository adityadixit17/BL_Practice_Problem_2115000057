import java.util.Scanner;

public class HarshadNumberChecker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        int sum = 0;
        int originalNumber = number;

        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Get the last digit
            sum += digit;                   // Add the digit to the sum
            originalNumber /= 10;           // Remove the last digit
        }

        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is not a Harshad Number.");
        }

        scanner.close();
    }
}

