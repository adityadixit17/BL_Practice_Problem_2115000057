class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;
    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}
class TicketReservationSystem {
    Ticket head = null;
    Ticket tail = null;
    void addTicketReservation(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            tail = newTicket;
            newTicket.next = head;  
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head; 
        }
    }
    void removeTicket(int ticketId) {
        if (head == null) return;
        Ticket temp = head;
        Ticket prev = null;
        do {
            if (temp.ticketId == ticketId) {
                if (prev != null) {
                    prev.next = temp.next;
                    if (temp == tail) tail = prev;
                } else {
                    head = temp.next;
                    tail.next = head;  
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }
    void searchTicketByCustomerName(String customerName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.customerName.equalsIgnoreCase(customerName)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Movie: " + temp.movieName +
                        ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tickets found for customer: " + customerName);
    }
    void searchTicketByMovieName(String movieName) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = head;
        boolean found = false;
        do {
            if (temp.movieName.equalsIgnoreCase(movieName)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Seat: " + temp.seatNumber + ", Booking Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) System.out.println("No tickets found for movie: " + movieName);
    }
    int totalTickets() {
        if (head == null) return 0;
        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }
}
public class TicketReservationSystemApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicketReservation(101, "Khushi", "Avatar", "A1", "2025-02-12 18:00");
        system.addTicketReservation(102, "Pooja", "Avengers", "B2", "2025-02-12 20:00");
        system.addTicketReservation(103, "Piyush", "Avatar", "C3", "2025-02-13 17:00");
        system.addTicketReservation(104, "Aditya", "Inception", "D4", "2025-02-14 16:00");
        system.displayTickets();
        System.out.println("\nSearch tickets by customer name (Khushi):");
        system.searchTicketByCustomerName("Khushi");
        System.out.println("\nSearch tickets by movie name (Avatar):");
        system.searchTicketByMovieName("Avatar");
        System.out.println("\nTotal tickets booked: " + system.totalTickets());
        System.out.println("\nRemoving ticket with ID 102:");
        system.removeTicket(102);
        system.displayTickets();
        System.out.println("\nTotal tickets booked after removal: " + system.totalTickets());
    }
}
