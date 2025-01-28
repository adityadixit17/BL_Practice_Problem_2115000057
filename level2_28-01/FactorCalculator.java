import java.util.Arrays;
import java.util.Scanner;

public class FactorCalculator {

    public static int[] findFactors(int number) {
        int[] temp = new int[number];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                temp[index++] = i;
            }
        }

        return Arrays.copyOf(temp, index);
    }

    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }

    public static double sumOfSquaresOfFactors(int[] factors) {
        double sum = 0;
        for (int factor : factors) {
            sum += Math.pow(factor, 2);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        int[] factors = findFactors(number);

        System.out.println("Factors of " + number + ": " + Arrays.toString(factors));

        int sum = sumOfFactors(factors);
        System.out.println("Sum of factors: " + sum);

        int product = productOfFactors(factors);
        System.out.println("Product of factors: " + product);

        double sumOfSquares = sumOfSquaresOfFactors(factors);
        System.out.println("Sum of square of factors: " + sumOfSquares);

        scanner.close();
    }
}

