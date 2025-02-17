import java.util.*;
public class DataStructureComparison {
    public static void main(String[] args) {
        int[] array = new int[1000000];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 1000000; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }
        int target = 999999;
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) break;
        }
        long endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) / 1000000 + " ms");
        startTime = System.nanoTime();
        hashSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) / 1000000 + " ms");        
        startTime = System.nanoTime();
        treeSet.contains(target);
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) / 1000000 + " ms");
    }
}
