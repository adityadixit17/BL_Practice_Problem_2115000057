import java.util.Scanner;

public class NumberChecker {

    public static String isPositive(int num) {
        return (num >= 0) ? "Positive" : "Negative";
    }

    public static String isEven(int num) {
        return (num % 2 == 0) ? "Even" : "Odd";
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) {
            return 1;
        } else if (num1 == num2) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");

        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            int num = numbers[i];
            System.out.print("Number " + num + " is ");
            System.out.println(isPositive(num));

            if (num >= 0) {
                System.out.println("It is " + isEven(num));
            }
        }

        int first = numbers[0];
        int last = numbers[4];
        int comparisonResult = compare(first, last);

        if (comparisonResult == 1) {
            System.out.println("First number is greater than the last number.");
        } else if (comparisonResult == 0) {
            System.out.println("First number is equal to the last number.");
        } else {
            System.out.println("First number is less than the last number.");
        }

        scanner.close();
    }
}

