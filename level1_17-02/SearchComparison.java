import java.util.*;
public class SearchTest {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) data[i] = rand.nextInt(size * 10);
            int target = data[rand.nextInt(size)];
            long start = System.nanoTime();
            for (int num : data) if (num == target) break;
            long linearTime = System.nanoTime() - start;
            Arrays.sort(data);
            start = System.nanoTime();
            Arrays.binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;
            System.out.println("Size: " + size + 
                               ", Linear: " + linearTime / 1e6 + " ms" +
                               ", Binary: " + binaryTime / 1e6 + " ms");
        }
    }
}
