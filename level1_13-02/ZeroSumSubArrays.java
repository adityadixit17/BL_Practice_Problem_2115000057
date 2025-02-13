import java.util.*;
public class ZeroSumSubarrays {
    public static void findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                System.out.println("Subarray [0, " + i + "]");
            }
            if (map.containsKey(sum)) {
                List<Integer> indices = map.get(sum);
                for (int index : indices) {
                    System.out.println("Subarray [" + (index + 1) + ", " + i + "]");
                }
            }       
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
    }
    public static void main(String[] args) {
        int[] arr = { 6, -1, -3, 4, 2, 2, 3, 1, -4, -2 };
        findZeroSumSubarrays(arr);
    }
}
