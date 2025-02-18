import java.util.*;
abstract class ProductCategory {
    String name;
    ProductCategory(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
}
class BookCategory extends ProductCategory {
    BookCategory() {
        super("Books");
    }
}
class ClothingCategory extends ProductCategory {
    ClothingCategory() {
        super("Clothing");
    }
}
class GadgetCategory extends ProductCategory {
    GadgetCategory() {
        super("Gadgets");
    }
}
class Product<T extends ProductCategory> {
    String name;
    double price;
    T category;   
    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
    void display() {
        System.out.println(name + " - " + category.getName() + ": $" + price);
    }
}
class ProductCatalog {
    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * (percentage / 100);
    }
}
public class OnlineMarketPlace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("Java Programming", 50.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("T-Shirt", 20.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone", 300.0, new GadgetCategory());
        ProductCatalog.applyDiscount(book, 10);
        ProductCatalog.applyDiscount(shirt, 5);
        ProductCatalog.applyDiscount(phone, 15);
        book.display();
        shirt.display();
        phone.display();
    }
}
