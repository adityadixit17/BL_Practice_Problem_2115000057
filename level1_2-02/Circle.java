import java.util.*;
public class Circle {
	private double radius;
	public Circle() {
		this.radius = 5;
	}
	public Circle(double radius) {
		this.radius = radius;
	}
	public void Display() {
		System.out.println("Circle with radius: " + radius);	
	}	
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		circle1.Display();
		Circle circle2 = new Circle(4);
		circle2.Display();
	}
}
