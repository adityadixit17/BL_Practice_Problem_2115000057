class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean availability;
    Book next;
    Book prev;
    Book(String title, String author, String genre, int bookId, boolean availability) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}
class Library {
    Book head = null;
    Book tail = null;
    void addBookAtBeginning(String title, String author, String genre, int bookId, boolean availability) {
        Book newBook = new Book(title, author, genre, bookId, availability);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }
    void addBookAtEnd(String title, String author, String genre, int bookId, boolean availability) {
        Book newBook = new Book(title, author, genre, bookId, availability);
        if (head == null) {
            head = newBook;
            tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }
    void addBookAtPosition(int position, String title, String author, String genre, int bookId, boolean availability) {
        Book newBook = new Book(title, author, genre, bookId, availability);
        if (position == 0) {
            addBookAtBeginning(title, author, genre, bookId, availability);
        } else {
            Book temp = head;
            for (int i = 1; i < position; i++) {
                if (temp.next == null) break;
                temp = temp.next;
            }
            newBook.next = temp.next;
            if (temp.next != null) temp.next.prev = newBook;
            newBook.prev = temp;
            temp.next = newBook;
        }
    }
    void removeBookById(int bookId) {
        if (head == null) return;
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp.prev != null) temp.prev.next = temp.next;
                else head = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
                else tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
    }
    void searchBookByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                System.out.println("Book Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookId + ", Available: " + temp.availability);
                return;
            }
            temp = temp.next;
        }
    }
    void searchBookByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equals(author)) {
                System.out.println("Book Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookId + ", Available: " + temp.availability);
                return;
            }
            temp = temp.next;
        }
    }
    void updateAvailabilityStatus(int bookId, boolean availability) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.availability = availability;
                return;
            }
            temp = temp.next;
        }
    }
    void displayBooksForward() {
        Book temp = head;
        while (temp != null) {
            System.out.println("Book Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookId + ", Available: " + temp.availability);
            temp = temp.next;
        }
    }
    void displayBooksReverse() {
        Book temp = tail;
        while (temp != null) {
            System.out.println("Book Title: " + temp.title + ", Author: " + temp.author + ", Genre: " + temp.genre + ", Book ID: " + temp.bookId + ", Available: " + temp.availability);
            temp = temp.prev;
        }
    }
    int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBookAtEnd("To Kill a Mockingbird", "Harper Lee", "Fiction", 101, true);
        library.addBookAtEnd("1984", "George Orwell", "Dystopian", 102, true);
        library.addBookAtBeginning("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 100, true);
        library.addBookAtPosition(1, "Moby Dick", "Herman Melville", "Adventure", 103, false);
        library.displayBooksForward();
        System.out.println();
        library.removeBookById(102);
        library.displayBooksForward();
        System.out.println();
        library.searchBookByTitle("Moby Dick");
        library.searchBookByAuthor("Harper Lee");
        System.out.println();
        library.updateAvailabilityStatus(101, false);
        library.displayBooksForward();
        System.out.println();
        library.displayBooksReverse();
        System.out.println("Total number of books: " + library.countBooks());
    }
}
