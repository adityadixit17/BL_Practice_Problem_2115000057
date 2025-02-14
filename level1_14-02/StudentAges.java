import java.util.Arrays;

public class StudentAges {
    public static void countingSort(int[] ages, int maxAge) {
        int[] count = new int[maxAge + 1];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age]++;
        }

        for (int i = 1; i <= maxAge; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i]] - 1] = ages[i];
            count[ages[i]]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 13, 17, 12, 16, 11};
        System.out.println("Before Sorting: " + Arrays.toString(studentAges));
        countingSort(studentAges, 18);
        System.out.println("After Sorting: " + Arrays.toString(studentAges));
    }
}
