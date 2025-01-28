import java.util.Scanner;

public class FriendComparison {

    public static String findYoungest(int[] ages) {
        int youngestAge = ages[0];
        String youngestFriend = "Amar";

        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < youngestAge) {
                youngestAge = ages[i];
                if (i == 1) {
                    youngestFriend = "Akbar";
                } else {
                    youngestFriend = "Anthony";
                }
            }
        }
        return youngestFriend;
    }

    public static String findTallest(double[] heights) {
        double tallestHeight = heights[0];
        String tallestFriend = "Amar";

        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > tallestHeight) {
                tallestHeight = heights[i];
                if (i == 1) {
                    tallestFriend = "Akbar";
                } else {
                    tallestFriend = "Anthony";
                }
            }
        }
        return tallestFriend;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        System.out.println("Enter the age and height of 3 friends:");

        System.out.print("Enter age of Amar: ");
        ages[0] = scanner.nextInt();
        System.out.print("Enter height of Amar (in meters): ");
        heights[0] = scanner.nextDouble();

        System.out.print("Enter age of Akbar: ");
        ages[1] = scanner.nextInt();
        System.out.print("Enter height of Akbar (in meters): ");
        heights[1] = scanner.nextDouble();

        System.out.print("Enter age of Anthony: ");
        ages[2] = scanner.nextInt();
        System.out.print("Enter height of Anthony (in meters): ");
        heights[2] = scanner.nextDouble();

        String youngestFriend = findYoungest(ages);
        System.out.println("The youngest friend is: " + youngestFriend);

        String tallestFriend = findTallest(heights);
        System.out.println("The tallest friend is: " + tallestFriend);

        scanner.close();
    }
}

