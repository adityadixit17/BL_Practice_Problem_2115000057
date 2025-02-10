// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    private double taxRate = 0.18;

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }

    @Override
    public String getTaxDetails() {
        return "Tax Rate: 18%";
    }
}

// Clothing class
class Clothing extends Product {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15;
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
}

// Main class
public class ECommercePlatform {
    public static void main(String[] args) {
        Product p1 = new Electronics(201, "Laptop", 1000);
        Product p2 = new Clothing(202, "T-Shirt", 50);
        Product p3 = new Groceries(203, "Apple", 5);

        printFinalPrice(p1);
        printFinalPrice(p2);
        printFinalPrice(p3);
    }

    public static void printFinalPrice(Product product) {
        double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
        double finalPrice = product.getPrice() + tax - product.calculateDiscount();
        System.out.println("Product: " + product.getName() + " | Final Price: $" + finalPrice);
    }
}


