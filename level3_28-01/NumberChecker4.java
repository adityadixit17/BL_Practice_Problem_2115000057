import java.util.Arrays;

public class NumberChecker4 {
    public static int[] findFactors(int number) {
        int[] temp = new int[number]; // Temporary array for storing factors
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                temp[index++] = i;
            }
        }
        return Arrays.copyOf(temp, index);
    }
    public static int greatestFactor(int number) {
        int[] factors = findFactors(number);
        return factors[factors.length - 1];
    }
    public static int sumOfFactors(int number) {
        int[] factors = findFactors(number);
        int sum = 0;
        for (int factor : factors) {
            sum += factor;
        }
        return sum;
    }

    public static int productOfFactors(int number) {
        int[] factors = findFactors(number);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product;
    }
    public static double productOfCubesOfFactors(int number) {
        int[] factors = findFactors(number);
        double product = 1.0;
        for (int factor : factors) {
            product *= Math.pow(factor, 3);
        }
        return product;
    }
    public static boolean isPerfectNumber(int number) {
        int sum = sumOfFactors(number) - number; // Proper divisors (exclude the number itself)
        return sum == number;
    }
    public static boolean isAbundantNumber(int number) {
        int sum = sumOfFactors(number) - number; // Proper divisors (exclude the number itself)
        return sum > number;
    }
    public static boolean isDeficientNumber(int number) {
        int sum = sumOfFactors(number) - number; // Proper divisors (exclude the number itself)
        return sum < number;
    }
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;

        while (temp > 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }

        return sum == number;
    }
    public static int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 28; // Example number
        System.out.println("Factors of " + number + ": " + Arrays.toString(findFactors(number)));
        System.out.println("Greatest factor of " + number + ": " + greatestFactor(number));
        System.out.println("Sum of factors of " + number + ": " + sumOfFactors(number));

        System.out.println("Product of factors of " + number + ": " + productOfFactors(number));

        System.out.println("Product of cubes of the factors of " + number + ": " + productOfCubesOfFactors(number));

        System.out.println("Is " + number + " a perfect number? " + isPerfectNumber(number));

        System.out.println("Is " + number + " an abundant number? " + isAbundantNumber(number));

        System.out.println("Is " + number + " a deficient number? " + isDeficientNumber(number));

        System.out.println("Is " + number + " a strong number? " + isStrongNumber(number));

        number = 145;

        System.out.println("\nTesting with number: " + number);
        System.out.println("Is " + number + " a perfect number? " + isPerfectNumber(number));
        System.out.println("Is " + number + " an abundant number? " + isAbundantNumber(number));
        System.out.println("Is " + number + " a deficient number? " + isDeficientNumber(number));
        System.out.println("Is " + number + " a strong number? " + isStrongNumber(number));
    }
}

