// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    // Abstract method to calculate fare based on distance
    public abstract double calculateFare(double distance);

    // Concrete method to get vehicle details
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + "\nDriver Name: " + driverName + "\nRate per KM: " + ratePerKm;
    }

    // Getters and Setters for encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

// Subclass Car
class Car extends Vehicle implements GPS {
    private String location;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Subclass Bike
class Bike extends Vehicle implements GPS {
    private String location;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Subclass Auto
class Auto extends Vehicle implements GPS {
    private String location;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return location;
    }

    @Override
    public void updateLocation(String newLocation) {
        location = newLocation;
    }
}

// Main class to test polymorphism and other features
public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle car = new Car("C123", "John Doe", 10.0);
        Vehicle bike = new Bike("B456", "Alice Smith", 5.0);
        Vehicle auto = new Auto("A789", "Bob Lee", 7.0);

        // Demonstrating polymorphism - calculating fare for different vehicles
        System.out.println("Fare for Car (10 km): " + car.calculateFare(10));
        System.out.println("Fare for Bike (10 km): " + bike.calculateFare(10));
        System.out.println("Fare for Auto (10 km): " + auto.calculateFare(10));

        // Displaying vehicle details
        System.out.println("\nCar Details:\n" + car.getVehicleDetails());
        System.out.println("\nBike Details:\n" + bike.getVehicleDetails());
        System.out.println("\nAuto Details:\n" + auto.getVehicleDetails());

        // Demonstrating GPS functionality
        ((GPS) car).updateLocation("Downtown");
        ((GPS) bike).updateLocation("Uptown");
        ((GPS) auto).updateLocation("City Center");

        System.out.println("\nCar current location: " + ((GPS) car).getCurrentLocation());
        System.out.println("Bike current location: " + ((GPS) bike).getCurrentLocation());
        System.out.println("Auto current location: " + ((GPS) auto).getCurrentLocation());
    }
}

