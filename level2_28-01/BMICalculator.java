import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] data = new double[10][3];
        String[] status = new String[10];

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter weight (in kg) for person " + (i + 1) + ":");
            data[i][0] = sc.nextDouble();
            System.out.println("Enter height (in cm) for person " + (i + 1) + ":");
            data[i][1] = sc.nextDouble() / 100;
        }

        calculateBMI(data);
        status = determineStatus(data);

        for (int i = 0; i < 10; i++) {
            System.out.println("Person " + (i + 1) + ": Weight = " + data[i][0] + " kg, Height = " + (data[i][1] * 100) + " cm, BMI = " + data[i][2] + ", Status = " + status[i]);
        }
    }

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            data[i][2] = data[i][0] / (data[i][1] * data[i][1]);
        }
    }

    public static String[] determineStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            if (data[i][2] <= 18.4) {
                status[i] = "Underweight";
            } else if (data[i][2] <= 24.9) {
                status[i] = "Normal";
            } else if (data[i][2] <= 39.9) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }
        return status;
    }
}
