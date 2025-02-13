import java.util.*;
class CustomHashMap {
    private static final int SIZE = 16;
    private List<LinkedList<Entry>> table;
    public CustomHashMap() {
        table = new ArrayList<>(SIZE);
        for (int i = 0; i < SIZE; i++) {
            table.add(new LinkedList<>());
        }
    }
    private int hash(int key) {
        return key % SIZE;
    }
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Entry> list = table.get(index);
        for (Entry entry : list) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        list.add(new Entry(key, value));
    }
    public Integer get(int key) {
        int index = hash(key);
        LinkedList<Entry> list = table.get(index);
        for (Entry entry : list) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Entry> list = table.get(index);
        list.removeIf(entry -> entry.key == key);
    }
    private static class Entry {
        int key;
        int value;
        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(2, 20);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        map.remove(1);
        System.out.println(map.get(1));
    }
}
