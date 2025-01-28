import java.util.Scanner;

public class ques11 {
    public static double calculateWindChill(double temperature, double windSpeed) {
        double windChill = 35.74 + (0.6215 * temperature) + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
        return windChill;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the temperature in Fahrenheit: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the wind speed in miles per hour: ");
        double windSpeed = scanner.nextDouble();
        if (windSpeed >= 3) {
            double windChill = calculateWindChill(temperature, windSpeed);
            System.out.println("The wind chill temperature is: " + windChill + "°F");
        } else {
            System.out.println("The wind chill formula is valid for wind speeds of 3 mph or greater.");
        }

        scanner.close();
    }
}
