import java.util.*;
public class ques6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of persons: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            double weight = scanner.nextDouble();
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            double height = scanner.nextDouble();
            double bmi = weight / (height * height);
            String status = (bmi < 18.5) ? "Underweight" : (bmi < 24.9) ? "Normal weight" : (bmi < 39.9) ? "Overweight" : "Obese";
            System.out.printf("Person %d | Weight: %.2f kg | Height: %.2f m | BMI: %.2f | Status: %s\n", 
                              i + 1, weight, height, bmi, status);
        }
    }
}
