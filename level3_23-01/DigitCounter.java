import java.util.Scanner;

public class DigitCounter {
    public static void main(String[] args) {
     
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int count = 0;

        if (number == 0) {
            count = 1;
        } else {
            // Loop to count digits
            while (number != 0) {
                number /= 10; // Remove the last digit
                count++;      // Increment the count
            }
        }

        System.out.println("The number of digits is: " + count);

        scanner.close();
    }
}

