class Book {
    String title;
    int publicationYear;
    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class Author extends Book {
    String name;
    String bio;
    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Author author = new Author("2 States", 2009, "Chetan Bhagat", "Chetan Bhagat is a popular Indian author and screenwriter.");
        author.displayInfo();
    }
}
