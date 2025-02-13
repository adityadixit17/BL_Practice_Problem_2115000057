import java.util.*;
public class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
	    int complement = target - num;
            if (map.containsKey(complement)) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }   
        return false;
    }
    public static void main(String[] args) {
        int[] arr = { 10, 15, 3, 7 };
        int target = 17;        
        if (hasPairWithSum(arr, target)) {
            System.out.println("Pair exists with the given sum.");
        } else {
            System.out.println("No pair found with the given sum.");
        }
    }
}
