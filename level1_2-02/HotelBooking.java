import java.util.*;
public class HotelBooking {
        private String guestName;
        private String roomType;
        private int nights;
        public HotelBooking() {
                this.guestName = "Khushi";
                this.roomType = "Double";
                this.nights = 3;
        }
        public HotelBooking(String guestName, String roomType, int nights) {
                this.guestName = guestName;
                this.roomType = roomType;
                this.nights = nights;
        }
	public HotelBooking(HotelBooking another) {
                this.guestName = another.guestName;
                this.roomType = another.roomType;
		this.nights = another.nights;
        }
        public void Display() {
                System.out.println("Guest Name: " + guestName);
                System.out.println("Room Type: " + roomType);
                System.out.println("Nights: " + nights);
        }
        public static void main(String[] args) {
                HotelBooking guest1 = new HotelBooking();
                guest1.Display();
                HotelBooking guest2 = new HotelBooking("Piyush", "Double", 4);
                guest2.Display();
		HotelBooking guest3 = new HotelBooking(guest2);
		guest3.Display();
        }
}


