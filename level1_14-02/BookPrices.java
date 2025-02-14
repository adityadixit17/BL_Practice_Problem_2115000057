import java.util.Arrays;

public class BookPrices {
    public static void merge(int[] prices, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] leftArray = new int[n1], rightArray = new int[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = prices[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            prices[k++] = (leftArray[i] <= rightArray[j]) ? leftArray[i++] : rightArray[j++];
        }
        while (i < n1) prices[k++] = leftArray[i++];
        while (j < n2) prices[k++] = rightArray[j++];
    }

    public static void mergeSort(int[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            merge(prices, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] bookPrices = {499, 299, 150, 899, 750, 400};
        System.out.println("Before Sorting: " + Arrays.toString(bookPrices));
        mergeSort(bookPrices, 0, bookPrices.length - 1);
        System.out.println("After Sorting: " + Arrays.toString(bookPrices));
    }
}
