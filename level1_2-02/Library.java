import java.util.*;
public class Library {
    private String title;
    private String author;
    double price;
    boolean availability;
    public Library(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }
    public void borrowBook() {
        if (availability) {
            availability = false; 
            System.out.println("You have borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }
    public void Display() {
	System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
    }
    public static void main(String[] args) {
        Library book1 = new Library("The Great Gatsby", "F. Scott Fitzgerald", 10.99, true);
	book1.Display();
        book1.borrowBook();
        System.out.println("Availability after borrowing: " + (book1.availability ? "Available" : "Not Available"));
    }
}
