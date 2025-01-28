import java.util.Scanner;

public class Quadratic {

    public static double[] findRoots(int a, int b, int c) {
        double delta = Math.pow(b, 2) - 4 * a * c;
        double[] roots;

        if (delta > 0) {
            roots = new double[2];
            roots[0] = (-b + Math.sqrt(delta)) / (2 * a);
            roots[1] = (-b - Math.sqrt(delta)) / (2 * a);
        } else if (delta == 0) {
            roots = new double[1];
            roots[0] = -b / (2 * a);
        } else {
            roots = new double[0]; // No real roots
        }

        return roots;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of a: ");
        int a = scanner.nextInt();
        System.out.print("Enter the value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter the value of c: ");
        int c = scanner.nextInt();

        double[] roots = findRoots(a, b, c);

        if (roots.length == 2) {
            System.out.println("The roots are: " + roots[0] + " and " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("The root is: " + roots[0]);
        } else {
            System.out.println("No real roots.");
        }

        scanner.close();
    }
}

