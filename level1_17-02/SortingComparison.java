import java.util.*;
public class SortingComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();
        for (int size : sizes) {
            int[] data = rand.ints(size, 1, size * 10).toArray();
            int[] bubbleData = Arrays.copyOf(data, data.length);
            int[] mergeData = Arrays.copyOf(data, data.length);
            int[] quickData = Arrays.copyOf(data, data.length);
            long start = System.nanoTime();
            bubbleSort(bubbleData);
            long bubbleTime = System.nanoTime() - start;
            start = System.nanoTime();
            mergeSort(mergeData);
            long mergeTime = System.nanoTime() - start;
            start = System.nanoTime();
            quickSort(quickData, 0, quickData.length - 1);
            long quickTime = System.nanoTime() - start;
            System.out.println("Size: " + size +
                               ", Bubble: " + bubbleTime / 1e6 + " ms" +
                               ", Merge: " + mergeTime / 1e6 + " ms" +
                               ", Quick: " + quickTime / 1e6 + " ms");
        }
    }
    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
    static void mergeSort(int[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }
    static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length)
            arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pivot = arr[high], i = low;
        for (int j = low; j < high; j++)
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        arr[high] = arr[i];
        arr[i] = pivot;
        quickSort(arr, low, i - 1);
        quickSort(arr, i + 1, high);
    }
}
