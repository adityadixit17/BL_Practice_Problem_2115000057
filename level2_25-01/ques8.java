import java.util.*;
public class ques8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        String[] grades = new String[n];
        for (int i = 0; i < n; i++) {
            int physics, chemistry, maths;
            do {
                System.out.print("Physics marks: ");
                physics = scanner.nextInt();
            } while (physics < 0);
            do {
                System.out.print("Chemistry marks: ");
                chemistry = scanner.nextInt();
            } while (chemistry < 0);
            do {
                System.out.print("Maths marks: ");
                maths = scanner.nextInt();
            } while (maths < 0);
            marks[i][0] = physics;
            marks[i][1] = chemistry;
            marks[i][2] = maths;
            double total = physics + chemistry + maths;
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
