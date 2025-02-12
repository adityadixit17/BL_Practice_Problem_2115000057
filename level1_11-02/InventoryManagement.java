class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;
    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
class Inventory {
    Item head = null;
    void addItemAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }
    void addItemAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newItem;
        }
    }
    void addItemAtPosition(int position, String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (position == 0) {
            addItemAtBeginning(itemName, itemId, quantity, price);
        } else {
            Item temp = head;
            for (int i = 1; i < position; i++) {
                if (temp.next == null) break;
                temp = temp.next;
            }
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }
    void removeItemById(int itemId) {
        if (head == null) return;
        if (head.itemId == itemId) {
            head = head.next;
	    return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
    void updateQuantityById(int itemId, int quantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = quantity;
                return;
            }
            temp = temp.next;
        }
    }
    void searchItemById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }
    void searchItemByName(String itemName) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemName.equals(itemName)) {
                System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
    }
    void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Value of Inventory: " + totalValue);
    }
    void sortInventoryByName() {
        if (head == null) return;
        Item current = head;
        Item index = null;
        String tempName;
        int tempId, tempQuantity;
        double tempPrice;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.itemName.compareTo(index.itemName) > 0) {
                    tempName = current.itemName;
                    tempId = current.itemId;
                    tempQuantity = current.quantity;
                    tempPrice = current.price;
                    current.itemName = index.itemName;
                    current.itemId = index.itemId;
                    current.quantity = index.quantity;
                    current.price = index.price;
                    index.itemName = tempName;
                    index.itemId = tempId;
                    index.quantity = tempQuantity;
                    index.price = tempPrice;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
    void sortInventoryByPrice() {
        if (head == null) return;
        Item current = head;
        Item index = null;
        String tempName;
        int tempId, tempQuantity;
        double tempPrice;
        while (current != null) {
            index = current.next;
            while (index != null) {
                if (current.price > index.price) {
                    tempName = current.itemName;
                    tempId = current.itemId;
                    tempQuantity = current.quantity;
                    tempPrice = current.price;
                    current.itemName = index.itemName;
                    current.itemId = index.itemId;
                    current.quantity = index.quantity;
                    current.price = index.price;
                    index.itemName = tempName;
                    index.itemId = tempId;
                    index.quantity = tempQuantity;
                    index.price = tempPrice;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
    void displayInventory() {
        Item temp = head;
        while (temp != null) {
            System.out.println("Item Name: " + temp.itemName + ", Item ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price);
            temp = temp.next;
        }
    }
}
public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtEnd("Laptop", 101, 10, 700.00);
        inventory.addItemAtEnd("Phone", 102, 20, 500.00);
        inventory.addItemAtBeginning("Tablet", 100, 30, 300.00);
        inventory.addItemAtPosition(1, "Headphones", 103, 15, 100.00);
        inventory.displayInventory();
        inventory.removeItemById(102);
        inventory.displayInventory();
        inventory.updateQuantityById(101, 12);
        inventory.displayInventory();
        inventory.searchItemById(101);
        inventory.searchItemByName("Tablet");
        inventory.calculateTotalValue();
        inventory.sortInventoryByName();
        inventory.displayInventory();
        inventory.sortInventoryByPrice();
        inventory.displayInventory();
    }
}
