interface Refuelable {
    void refuel();
}
class Vehicle {
    int maxSpeed;
    String model;
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }
    public int getMaxSpeed() {
        return maxSpeed;
    }
    public String getModel() {
        return model;
    }
}
class ElectricVehicle extends Vehicle {
    public ElectricVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    public void charge() {
        System.out.println(getModel() + " is charging.");
    }
}
class PetrolVehicle extends Vehicle implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) {
        super(maxSpeed, model);
    }
    public void refuel() {
        System.out.println(getModel() + " is refueling.");
    }
}
public class VehicleManagement {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model S");
        PetrolVehicle pv = new PetrolVehicle(120, "Toyota Corolla");
        ev.charge();
        pv.refuel();
    }
}
