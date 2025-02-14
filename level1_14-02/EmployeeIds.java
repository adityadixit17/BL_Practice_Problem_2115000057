import java.util.Arrays;

public class EmployeeIds {
    
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i]; 
            int j = i - 1;

            
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key; 
        }
    }

    public static void main(String[] args) {
        int[] employeeIDs = {104, 101, 109, 102, 107, 103};

        System.out.println("Before Sorting: " + Arrays.toString(employeeIDs));
        insertionSort(employeeIDs);
        System.out.println("After Sorting: " + Arrays.toString(employeeIDs));
    }
}
