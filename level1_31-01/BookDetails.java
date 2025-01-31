import java.util.*;
class Book {
	String title;
	String author;
	double price;
	public Book(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price; 
	}
	public void Display() {
		System.out.println("Book Title: " + title);
        	System.out.println("Book Author Name: " + author);
        	System.out.println("Book Price: $" + price);
	}
}
public class BookDetails {
	public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Enter Book Title: ");
	        String title = sc.nextLine();
	        System.out.println("Enter Book Author Name: ");
	        String author = sc.nextLine();
	        System.out.println("Enter Book Price: ");
	        double price = sc.nextDouble();
	        Book book = new Book(title, author, price);
	        System.out.println("\nBook Details :- ");
	        book.Display();
	}

}

