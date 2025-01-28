public class NumberChecker3 {
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isNeon(int number) {
        int square = number * number;
        int sumOfDigits = 0;
        while (square > 0) {
            sumOfDigits += square % 10;
            square /= 10;
        }
        return sumOfDigits == number;
    }

    public static boolean isSpy(int number) {
        int sum = 0, product = 1;
        while (number > 0) {
            int digit = number % 10;
            sum += digit;
            product *= digit;
            number /= 10;
        }
        return sum == product;
    }

    public static boolean isAutomorphic(int number) {
        int square = number * number;
        return String.valueOf(square).endsWith(String.valueOf(number));
    }

    public static boolean isBuzz(int number) {
        return number % 7 == 0 || String.valueOf(number).endsWith("7");
    }

    public static void main(String[] args) {
        int number = 25;  // Example number

        System.out.println("Is the number prime? " + isPrime(number));

        System.out.println("Is the number a neon number? " + isNeon(number));

        System.out.println("Is the number a spy number? " + isSpy(number));

        System.out.println("Is the number an automorphic number? " + isAutomorphic(number));
        System.out.println("Is the number a buzz number? " + isBuzz(number));
        number = 7;

        System.out.println("\nTesting with number: " + number);
        System.out.println("Is the number prime? " + isPrime(number));
        System.out.println("Is the number a neon number? " + isNeon(number));
        System.out.println("Is the number a spy number? " + isSpy(number));
        System.out.println("Is the number an automorphic number? " + isAutomorphic(number));
        System.out.println("Is the number a buzz number? " + isBuzz(number));
    }
}

