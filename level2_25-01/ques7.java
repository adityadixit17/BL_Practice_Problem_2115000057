import java.util.*;
public class ques7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();
        double[][] personData = new double[n][3];
        String[] weightStatus = new String[n];
        for (int i = 0; i < n; i++) {
            double weight, height;
            do {
                System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
                weight = scanner.nextDouble();
            } while (weight <= 0);
            do {
                System.out.print("Enter height (m) for person " + (i + 1) + ": ");
                height = scanner.nextDouble();
            } while (height <= 0);
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = weight / (height * height);
            if (personData[i][2] < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] < 24.9) {
                weightStatus[i] = "Normal weight";
            } else if (personData[i][2] < 29.9) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }
        System.out.println("\nBMI Calculation Results:");
        System.out.println("----------------------------------------------------");
        System.out.println("Person | Weight (kg) | Height (m) | BMI   | Status");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-6d | %-12.2f | %-11.2f | %-5.2f | %s\n", 
                              i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
