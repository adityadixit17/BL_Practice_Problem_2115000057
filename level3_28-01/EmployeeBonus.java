import java.util.Random;

public class EmployeeBonus {
    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] updatedData = calculateBonusAndNewSalary(employeeData);
        displaySummary(employeeData, updatedData);
    }

    public static double[][] generateEmployeeData(int numEmployees) {
        Random rand = new Random();
        double[][] data = new double[numEmployees][2];
        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = 30000 + rand.nextInt(70001); // Random salary between 30000 and 100000
            data[i][1] = rand.nextInt(16);           // Random years of service between 0 and 15
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] data) {
        double[][] result = new double[data.length][2];
        for (int i = 0; i < data.length; i++) {
            double salary = data[i][0];
            double yearsOfService = data[i][1];
            double bonusPercentage = (yearsOfService >= 5) ? 5 : 2;
            double bonus = salary * bonusPercentage / 100;
            result[i][0] = salary + bonus;
            result[i][1] = bonus;
        }
        return result;
    }

    public static void displaySummary(double[][] oldData, double[][] newData) {
        double oldSalarySum = 0, newSalarySum = 0, totalBonus = 0;
        System.out.printf("%-10s %-10s %-10s %-10s %-10s%n", "Salary", "Years", "NewSalary", "Bonus", "Total");
        for (int i = 0; i < oldData.length; i++) {
            oldSalarySum += oldData[i][0];
            newSalarySum += newData[i][0];
            totalBonus += newData[i][1];
            System.out.printf("%-10.2f %-10.2f %-10.2f %-10.2f%n", oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
        }
        System.out.printf("Total: %-10.2f %-10.2f %-10.2f%n", oldSalarySum, newSalarySum, totalBonus);
    }
}
