import java.util.*;
abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
}
class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
}
class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}
class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
}
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    void addItem(T item) {
        items.add(item);
    }
    List<T> getItems() {
        return items;
    }
    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName());
        }
    }
}
public class SmartWarehouse {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        groceriesStorage.addItem(new Groceries("Apple"));
        furnitureStorage.addItem(new Furniture("Chair"));
        Storage.displayItems(electronicsStorage.getItems());
        Storage.displayItems(groceriesStorage.getItems());
        Storage.displayItems(furnitureStorage.getItems());
    }
}
