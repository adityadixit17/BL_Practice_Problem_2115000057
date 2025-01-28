import java.util.Scanner;

public class CollinearPoints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        if (isCollinearSlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using the slope method.");
        } else if (isCollinearArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("The points are collinear using the area method.");
        } else {
            System.out.println("The points are not collinear.");
        }
        sc.close();
    }

    public static boolean isCollinearSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        int slopeAB = (y2 - y1) * (x3 - x2);
        int slopeBC = (y3 - y2) * (x2 - x1);
        return slopeAB == slopeBC;
    }

    public static boolean isCollinearArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        int area = x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2);
        return area == 0;
    }
}
