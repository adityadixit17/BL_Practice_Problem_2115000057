import java.util.Random;

public class RandomNumberAnalysis {

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            numbers[i] = 1000 + random.nextInt(9000); // Generates a random 4-digit number
        }
        
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        double[] result = new double[3];
        
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        result[0] = (double) sum / numbers.length; // average
        result[1] = min; // minimum
        result[2] = max; // maximum
        
        return result;
    }

    public static void main(String[] args) {
        int size = 5;
        int[] randomNumbers = generate4DigitRandomArray(size);

        System.out.println("Generated 4-digit random numbers:");
        for (int num : randomNumbers) {
            System.out.println(num);
        }

        double[] result = findAverageMinMax(randomNumbers);

        System.out.println("\nAverage: " + result[0]);
        System.out.println("Minimum: " + result[1]);
        System.out.println("Maximum: " + result[2]);
    }
}

