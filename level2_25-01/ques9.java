import java.util.*;
public class ques9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                int mark;
                do {
                    if (j == 0) System.out.print("Physics marks: ");
                    else if (j == 1) System.out.print("Chemistry marks: ");
                    else System.out.print("Maths marks: ");
                    mark = scanner.nextInt();
                } while (mark < 0);
                marks[i][j] = mark;
            }
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (total / 300) * 100;
            if (percentages[i] >= 80) grades[i] = "A";
            else if (percentages[i] >= 70) grades[i] = "B";
            else if (percentages[i] >= 60) grades[i] = "C";
            else if (percentages[i] >= 50) grades[i] = "D";
            else if (percentages[i] >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        System.out.println("\nStudent Results:");
        System.out.println("---------------------------------------------------------");
        System.out.println("Student | Physics | Chemistry | Maths | Percentage | Grade");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d | %-7d | %-9d | %-5d | %-10.2f | %s\n", 
                              i + 1, marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
