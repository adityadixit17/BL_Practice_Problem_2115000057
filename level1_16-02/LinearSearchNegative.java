public class LinearSearchNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] numbers = {3, 7, 5, -2, 8, -6, 10};
        int index = findFirstNegative(numbers);
        System.out.println("First negative number found at index: " + index);
    }
}
