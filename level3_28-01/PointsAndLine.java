import java.util.Scanner;

public class PointsAndLine {
    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1); // Slope (m)
        double yIntercept = y1 - slope * x1;  // Y-intercept (b)
        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the x-coordinate of the first point (x1): ");
        double x1 = scanner.nextDouble();

        System.out.print("Enter the y-coordinate of the first point (y1): ");
        double y1 = scanner.nextDouble();

        System.out.print("Enter the x-coordinate of the second point (x2): ");
        double x2 = scanner.nextDouble();

        System.out.print("Enter the y-coordinate of the second point (y2): ");
        double y2 = scanner.nextDouble();
        double distance = calculateDistance(x1, y1, x2, y2);
        System.out.printf("The Euclidean distance between the points is: %.2f%n", distance);

        if (x1 == x2) {
            System.out.println("The line is vertical, and the equation is x = " + x1);
        } else {
            double[] lineEquation = findLineEquation(x1, y1, x2, y2);
            double slope = lineEquation[0];
            double yIntercept = lineEquation[1];
            System.out.printf("The equation of the line is: y = %.2fx + %.2f%n", slope, yIntercept);
        }
    }
}

