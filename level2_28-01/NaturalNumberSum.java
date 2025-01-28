import java.util.Scanner;

public class NaturalNumberSum {

    public static int sumRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number greater than 0.");
            scanner.close();
            return;
        }

        int recursiveSum = sumRecursive(n);
        int formulaSum = sumFormula(n);

        System.out.println("Sum of first " + n + " natural numbers using recursion: " + recursiveSum);
        System.out.println("Sum of first " + n + " natural numbers using formula: " + formulaSum);

        if (recursiveSum == formulaSum) {
            System.out.println("Both methods give the same result.");
        } else {
            System.out.println("The results do not match.");
        }

        scanner.close();
    }
}

