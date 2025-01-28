import java.util.Scanner;

public class StudentVoteChecker {

    public boolean canStudentVote(int age) {
        if (age < 0) {
            return false;  // Invalid age, cannot vote
        } else if (age >= 18) {
            return true;   // Eligible to vote
        } else {
            return false;  // Not eligible to vote
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentVoteChecker checker = new StudentVoteChecker();

        int[] ages = new int[10];  // Array to store the ages of 10 students
        System.out.println("Enter the ages of 10 students:");

        // Loop to take input for 10 students' ages
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i + 1) + ": ");
            ages[i] = scanner.nextInt();  // Take input for each student's age
        }

        // Check voting eligibility for each student
        for (int i = 0; i < 10; i++) {
            if (checker.canStudentVote(ages[i])) {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") is eligible to vote.");
            } else {
                System.out.println("Student " + (i + 1) + " (Age: " + ages[i] + ") is not eligible to vote.");
            }
        }

        scanner.close();
    }
}

