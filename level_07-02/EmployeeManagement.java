class Employee {
	String name;
	int id;
	int salary;
	public Employee(String name, int id, int salary) {
		this.name = name;
		this.id = id;
		this.salary = salary;
	}
	public void displayDetails() {
		System.out.println("Employee's Name: " + name);
		System.out.println("Employee's ID: " + id);
		System.out.println("Employee's Salary: " + salary);
	}
}
class Manager extends Employee {
	int teamSize;
	public Manager(String name, int id, int salary, int teamSize) {
		super(name, id, salary);
		this.teamSize = teamSize;
	}
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Team Size = " + teamSize);
	}
}
class Developer extends Employee {
	String programmingLanguage;
	public Developer(String name, int id, int salary, String programmingLanguage) {
		super(name, id, salary);
		this.programmingLanguage = programmingLanguage;
	}	
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Programming Language = " + programmingLanguage);
	}
}
class Intern extends Employee {
	int durationMonths;
	public Intern(String name, int id, int salary, int durationMonths) {
		super(name, id, salary);
		this.durationMonths = durationMonths;
	}	
	public void displayDetails() {
		super.displayDetails();
		System.out.println("Duration: " + durationMonths + " months");
	}
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Employee manager = new Manager("Khushi", 1, 100000, 5);
        Employee developer = new Developer("Krishna", 2, 70000, "Java");
        Employee intern = new Intern("Baibhavi", 3, 10000, 6);
        manager.displayDetails();
        System.out.println();
        developer.displayDetails();
        System.out.println();
        intern.displayDetails();
    }
}
