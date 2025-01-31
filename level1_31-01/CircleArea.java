import java.util.*;
class Circle {
	double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public double area() {
		return Math.PI*Math.pow(radius,2);
	}
	public double circumference() {
		return 2*Math.PI*radius;
	}
	public void Display() {
		System.out.println("Circle with radius: " + radius);
		System.out.println("Area: " + area());
		System.out.println("Circumference: " + circumference());
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Radius of Circle: ");
		double radius = sc.nextDouble();
		Circle c = new Circle(radius);
		c.Display();
	}
}
