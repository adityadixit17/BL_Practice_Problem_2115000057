import java.util.Scanner;
public class ques7 {
    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer n: ");
        int n = scanner.nextInt();
        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int sum = sumOfNaturalNumbers(n);
            System.out.println("The sum of the first " + n + " natural numbers is: " + sum);
        }

        scanner.close();
    }
}
