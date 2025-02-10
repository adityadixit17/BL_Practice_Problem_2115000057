// Abstract class FoodItem
import java.util.*;
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

// Interface Discountable
interface Discountable {
    void applyDiscount(double discount);
    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    private double discount = 0;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }

    @Override
    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: $" + discount;
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private double additionalCharge = 5.0; // Extra charge for non-veg items
    private double discount = 0;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return ((getPrice() * getQuantity()) + additionalCharge) - discount;
    }

    @Override
    public void applyDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String getDiscountDetails() {
        return "Discount applied: $" + discount;
    }
}

// Main class

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Veg Burger", 10.0, 2));
        order.add(new NonVegItem("Chicken Wings", 15.0, 1));

        for (FoodItem item : order) {
            System.out.println(item.getItemDetails() + " | Total Price: $" + item.calculateTotalPrice());
            
            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount(2.0);
                System.out.println(((Discountable) item).getDiscountDetails());
                System.out.println("New Total Price: $" + item.calculateTotalPrice());
            }
        }
    }
}

