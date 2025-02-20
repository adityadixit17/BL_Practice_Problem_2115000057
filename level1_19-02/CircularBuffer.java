import java.util.*;

public class CircularBuffer {
    private int[] buffer;
    private int size, head, tail, count;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
        head = 0;
        tail = 0;
        count = 0;
    }

    public void insert(int value) {
        buffer[tail] = value;
        tail = (tail + 1) % size;
        if (count < size) {
            count++;
        } else {
            head = (head + 1) % size;
        }
    }

    public List<Integer> getBuffer() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(buffer[(head + i) % size]);
        }
        return result;
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4); // Overwrites 1
        System.out.println(cb.getBuffer());     }
}
