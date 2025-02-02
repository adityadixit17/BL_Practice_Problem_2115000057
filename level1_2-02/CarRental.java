import java.util.*;
public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    double rentalCostPerDay;
    public CarRental(String customerName, String carModel, int rentalDays, double rentalCostPerDay) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.rentalCostPerDay = rentalCostPerDay;
    }
    public double calculateTotalCost() {
        return rentalDays * rentalCostPerDay;
    }
    public static void main(String[] args) {
        CarRental rental = new CarRental("John Doe", "Toyota Camry", 5, 50.0);
        System.out.println("Customer Name: " + rental.customerName);
        System.out.println("Car Model: " + rental.carModel);
        System.out.println("Rental Days: " + rental.rentalDays);
        System.out.println("Total Cost: $" + rental.calculateTotalCost());
    }
}
