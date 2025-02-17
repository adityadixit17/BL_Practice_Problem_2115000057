public class FibonacciTest {
    public static void main(String[] args) {
        int[] values = {10, 30, 50}; 
        for (int n : values) {
            long start = System.nanoTime();
            int recursiveResult = fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - start;
            start = System.nanoTime();
            int iterativeResult = fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - start;
            System.out.println("Fibonacci(" + n + "):");
            System.out.println("Recursive: " + recursiveTime / 1e6 + " ms");
            System.out.println("Iterative: " + iterativeTime / 1e6 + " ms");
        }
    }
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    public static int fibonacciIterative(int n) {
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
