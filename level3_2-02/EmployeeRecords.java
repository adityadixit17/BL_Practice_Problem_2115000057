class Employee {
    public int employeeID;
    protected String department;
    private double salary;
    public void modifySalary(double salary) {
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }
}
class Manager extends Employee {
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
    }
}
public class EmployeeRecords {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.employeeID = 101;
        manager.department = "Sales";
        manager.modifySalary(75000);
        manager.displayDetails();
        System.out.println("Salary: " + manager.getSalary());
    }
}
