import java.util.Scanner;

public class FizzBuzz2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        // Check if the input is positive
        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int i = 0;
            // Loop from 0 to the input number using while loop
            while (i <= number) {
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
                i++;
            }
        }

        scanner.close();
    }
}

