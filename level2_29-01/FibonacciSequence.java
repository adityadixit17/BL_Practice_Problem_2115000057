import java.util.Scanner;

public class FibonacciSequence {

    public static void generateFibonacci(int n) {
        int first = 0, second = 1;
        
        System.out.print("Fibonacci Sequence: ");
        
        for (int i = 0; i < n; i++) {
            System.out.print(first + " ");
            int nextTerm = first + second;
            first = second;
            second = nextTerm;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        generateFibonacci(n);
    }
}

