import java.util.Scanner;

public class LeapYear {

    public static String isLeapYearIfElse(int year) {
        if (year < 1582) {
            return "The year must be >= 1582.";
        }

        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return "Year is a Leap Year.";
                } else {
                    return "Year is not a Leap Year.";
                }
            } else {
                return "Year is a Leap Year.";
            }
        } else {
            return "Year is not a Leap Year.";
        }
    }

    public static String isLeapYearSingleIf(int year) {
        if (year < 1582) {
            return "The year must be >= 1582.";
        }

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return "Year is a Leap Year.";
        } else {
            return "Year is not a Leap Year.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a year: ");
        int year = scanner.nextInt();

        String resultIfElse = isLeapYearIfElse(year);
        System.out.println("(Multiple if-else): " + resultIfElse);

        String resultSingleIf = isLeapYearSingleIf(year);
        System.out.println("(Single if): " + resultSingleIf);

        scanner.close();
    }
}

