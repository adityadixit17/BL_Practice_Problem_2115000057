import java.util.Scanner;

public class FactorialUsingRecursion {

    public static int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        return scanner.nextInt();
    }

    public static int calculateFactorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    public static void displayResult(int result) {
        System.out.println("The factorial is: " + result);
    }

    public static void main(String[] args) {
        int number = getInput();
        int factorial = calculateFactorial(number);
        displayResult(factorial);
    }
}

