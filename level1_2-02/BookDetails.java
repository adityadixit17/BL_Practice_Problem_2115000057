import java.util.*;
public class BookDetails {
	private String title;
	private String author;
	private double price;
	public BookDetails() {
		this.title = "2 States";
		this.author = "Chetan Bhagat";
		this.price = 50.5;
	}
	public BookDetails(String title, String author, double price) {
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public void Display() {
		System.out.println("Book Title: " + title);
		System.out.println("Book Author Name: " + author);
		System.out.println("Book Price: " + price);
	}
	public static void main(String[] args) {
		BookDetails book1 = new BookDetails();
		book1.Display();
		BookDetails book2 = new BookDetails("Half Girlfriend", "Chetan Bhagat", 400.0);
		book2.Display();
	}
}

