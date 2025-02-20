import java.util.*;

public class ReverseList {
    
    public static <T> List<T> reverseArrayList(List<T> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
        return list;
    }

    public static <T> LinkedList<T> reverseLinkedList(LinkedList<T> list) {
        LinkedList<T> reversedList = new LinkedList<>();
        for (T item : list) {
            reversedList.addFirst(item); 
        }
        return reversedList;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        
        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reverseArrayList(arrayList));
        
        System.out.println("Original LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reverseLinkedList(linkedList));
    }
}
