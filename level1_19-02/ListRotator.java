import java.util.*;

public class ListRotator {
    public static List<Integer> rotateList(List<Integer> list, int positions) {
        int size = list.size();
        positions = positions % size;         
        List<Integer> rotatedList = new ArrayList<>(list.subList(positions, size));
        rotatedList.addAll(list.subList(0, positions));
        
        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> input = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;
        List<Integer> result = rotateList(input, rotateBy);
        System.out.println(result);   
  }
}

