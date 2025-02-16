import java.util.Arrays;
public class LinearAndBinarySearch {
    public static int findFirstMissingPositive(int[] arr) {
        int n = arr.length;
        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num > 0 && num <= n) {
                present[num] = true;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (!present[i]) {
                return i;
            }
        }
        return n + 1;
    }
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {3, 4, -1, 1};
        int target = 3;
        int missingNumber = findFirstMissingPositive(array);
        System.out.println("First missing positive integer: " + missingNumber);
        Arrays.sort(array);
        int targetIndex = binarySearch(array, target);
        System.out.println("Index of target " + target + ": " + targetIndex);
    }
}
