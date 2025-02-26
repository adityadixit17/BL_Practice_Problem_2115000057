package D_26_02_25;

import com.fasterxml.jackson.databind.ObjectMapper;
class Car {
    private String brand;
    private String model;
    private int year;
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }
}
public class CarJsonExample {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Car car = new Car("Toyota", "Camry", 2022);
            String jsonString = objectMapper.writeValueAsString(car);
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
