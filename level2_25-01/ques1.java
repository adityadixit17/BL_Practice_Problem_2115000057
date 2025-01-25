import java.util.*;
public class ques1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] salary = new double[10];
        double[] yearsOfService = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter salary for employee " + (i + 1) + ": ");
            salary[i] = scanner.nextDouble();
            while (salary[i] <= 0) {
                System.out.print("Invalid salary. Please enter a valid salary: ");
                salary[i] = scanner.nextDouble();
            }
            System.out.print("Enter years of service for employee " + (i + 1) + ": ");
            yearsOfService[i] = scanner.nextDouble();
            while (yearsOfService[i] < 0) {
                System.out.print("Invalid years of service. Please enter a valid number: ");
                yearsOfService[i] = scanner.nextDouble();
            }
            totalOldSalary += salary[i];
        }
        for (int i = 0; i < 10; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }
            newSalary[i] = salary[i] + bonus[i];
            totalBonus += bonus[i];
            totalNewSalary += newSalary[i];
        }
        System.out.println("\nTotal bonus payout: " + totalBonus);
        System.out.println("Total old salary: " + totalOldSalary);
        System.out.println("Total new salary: " + totalNewSalary);
    }
}
