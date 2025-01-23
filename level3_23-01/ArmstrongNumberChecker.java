import java.util.Scanner;

public class ArmstrongNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int sum = 0;
        int originalNumber = number;

        while (originalNumber != 0) {
            int remainder = originalNumber % 10; // Find the last digit
            sum += Math.pow(remainder, 3); // Add the cube of the digit to the sum
            originalNumber /= 10; // Remove the last digit
        }

        if (sum == number) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }

        scanner.close();
    }
}

