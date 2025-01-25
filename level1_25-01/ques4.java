import java.util.*;
public class ques4 {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (enter 0 or a negative number to stop): ");
            double number = scanner.nextDouble();
            if (number <= 0) {
                break;
            }
            if (index >= 10) {
                break;
            }
            numbers[index] = number;
            index++;
        }
        System.out.println("\nThe numbers entered are:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i]; // Add the number to the total
        }
        System.out.println("\nThe total sum of the numbers is: " + total);
    }
}
