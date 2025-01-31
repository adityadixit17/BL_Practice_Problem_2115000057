import java.util.*;
class Employee {
    String name;
    int empId;
    double salary;
    public Employee(String name, int empId, double salary) {
        this.name = name;
	this.empId = empId;
	this.salary = salary;
    }
    public void Display() {
        System.out.println("Employee Name: " + name);
	System.out.println("Employee ID: " + empId);
	System.out.println("Employee Salary: $" + salary);
    }
}
public class EmployeeDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter Employee Name: ");
	String name = sc.nextLine();
	System.out.println("Enter Employee ID: ");
        int empId = sc.nextInt();
	System.out.println("Enter Employee Salary: ");
        double salary = sc.nextDouble();
	Employee emp = new Employee(name, empId, salary);
	System.out.println("\nEmployee Details :- ");
	emp.Display();
    }
}
