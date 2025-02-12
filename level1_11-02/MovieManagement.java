import java.util.*;
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;
    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}
class MovieDoublyLinkedList {
    private MovieNode head;
    private MovieNode tail;
    public MovieDoublyLinkedList() {
        head = null;
        tail = null;
    }
    public void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }
    public void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }
    public void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (position == 0) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode temp = head;
        for (int i = 0; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    public void removeMovieByTitle(String title) {
        if (head == null) return;
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
	    System.out.println("Data of " + title + " has been deleted.");
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title)) {
            temp = temp.next;
	    System.out.println("Data of " + title + " has been deleted.");
        }
        if (temp == null) {
            System.out.println("Movie not found.");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }
    public MovieNode searchMovieByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public MovieNode searchMovieByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating == rating) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
    public void updateMovieRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                System.out.println("Rating of " + title + " has been updated.");
	    	return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }
    public void displayAllMoviesForward() {
        MovieNode temp = head;
        if (temp == null) {
            System.out.println("No movies to display.");
            return;
        }
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.next;
        }
    }
    public void displayAllMoviesReverse() {        
	MovieNode temp = tail;
        if (temp == null) {
            System.out.println("No movies to display.");
            return;
        }
	System.out.println("Movie Details in Reverse order: ");
        while (temp != null) {
            System.out.println("Title: " + temp.title + ", Director: " + temp.director + ", Year: " + temp.year + ", Rating: " + temp.rating);
            temp = temp.prev;
        }
    }
}
public class MovieManagement {
    public static void main(String[] args) {
        MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
        movieList.addMovieAtBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addMovieAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addMovieAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);
        movieList.displayAllMoviesForward();
        movieList.addMovieAtPosition("The Prestige", "Christopher Nolan", 2006, 8.5, 1);
        movieList.displayAllMoviesForward();
        movieList.removeMovieByTitle("Inception");
        movieList.displayAllMoviesForward();
        MovieNode movie = movieList.searchMovieByDirector("Christopher Nolan");
        if (movie != null) {
            System.out.println("Found movie: " + movie.title);
        } else {
            System.out.println("Movie not found.");
        }
        movieList.updateMovieRating("The Dark Knight", 9.1);
        movieList.displayAllMoviesForward();
        movieList.displayAllMoviesReverse();
    }
}

