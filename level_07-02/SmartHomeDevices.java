class Device {
	String deviceId;
	String status;
	public Device(String deviceId, String status) {
		this.deviceId = deviceId;
		this.status = status;
	}
	public void displayStatus() {
		System.out.println("Device ID: " + deviceId);
		System.out.println("Status: " + status);
	}
}
class Thermostat extends Device {
	int temperatureSetting;
	public Thermostat(String deviceId, String status, int temperatureSetting) {
		super(deviceId, status);
		this.temperatureSetting = temperatureSetting;
	}	
	public void displayStatus() {
		super.displayStatus();
		System.out.println("Temperature Setting: " + temperatureSetting + " Celsius");
	}
}
public class SmartHomeDevices {
	public static void main(String args[]) {
		Thermostat thermo = new Thermostat("D1", "ON", 25);
		thermo.displayStatus();
	}	
}
