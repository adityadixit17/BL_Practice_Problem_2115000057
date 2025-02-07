class Vehicle {
    int maxSpeed;
    String fuelType;
    public Vehicle(int maxSpeed, String fuelType) {
	this.maxSpeed = maxSpeed;
	this.fuelType = fuelType;
    }
    public void displayInfo() {
        System.out.println("Maximum Speed = " + maxSpeed);
        System.out.println("Fuel Type = " + fuelType);
    }
}
class Car extends Vehicle {
    int seatCapacity;
    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    public void displayInfo() {
	System.out.println("Car Details:-");
        super.displayInfo();
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}
class Truck extends Vehicle {
    double loadCapacity;
    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }
    public void displayInfo() {
	System.out.println("Truck Details:-");
        super.displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}
class Motorcycle extends Vehicle {
    boolean hasSideCar;
    public Motorcycle(int maxSpeed, String fuelType, boolean hasSideCar) {
        super(maxSpeed, fuelType);
        this.hasSideCar = hasSideCar;
    }
    public void displayInfo() {
	System.out.println("MotorCycle Details:-");
        super.displayInfo();
        System.out.println("Has Sidecar: " + hasSideCar);
    }
}
public class VehicleTransport {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car(200, "Petrol", 5),
            new Truck(120, "Diesel", 10),
            new Motorcycle(180, "Petrol", false)
        };
        for (Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            System.out.println();
        }
    }	
}

