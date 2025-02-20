import java.util.*;

class ShoppingCart {
    private final HashMap<String, Double> productPrices;  
    private final LinkedHashMap<String, Integer> cart;    

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cart = new LinkedHashMap<>();
    }

    public void addProduct(String name, double price) {
        productPrices.put(name, price);
    }

    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayCart() {
        System.out.println("\nShopping Cart (Ordered by Addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(product);
            System.out.println(product + " - Quantity: " + quantity + ", Price: $" + price);
        }
    }

    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            sortedMap.put(productPrices.get(product), product);
        }

        System.out.println("\nShopping Cart (Sorted by Price):");
        for (Map.Entry<Double, String> entry : sortedMap.entrySet()) {
            String product = entry.getValue();
            double price = entry.getKey();
            System.out.println(product + " - Price: $" + price);
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        
        cart.addProduct("Laptop", 1200.00);
        cart.addProduct("Phone", 800.00);
        cart.addProduct("Headphones", 150.00);
        cart.addProduct("Mouse", 50.00);

        cart.addToCart("Laptop", 1);
        cart.addToCart("Mouse", 2);
        cart.addToCart("Phone", 1);

        cart.displayCart();

        cart.displaySortedByPrice();
    }
}
