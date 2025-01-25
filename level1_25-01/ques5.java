import java.util.*;
public class ques5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to get its multiplication table (from 6 to 9): ");
        int number = scanner.nextInt();
        int[] multiplicationResult = new int[4]; 
        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
        }
        System.out.println("\nMultiplication table of " + number + ":");
        for (int i = 6; i <= 9; i++) {
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }
    }
}
