class Employee {
    private static String companyName = "Tech Solutions Inc.";
    private static int totalEmployees = 0;
    
    private final int id;
    private String name;
    private String designation;
    
    // Constructor
    public Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id;
        this.designation = designation;
        totalEmployees++;
    }
    
    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    
    // Method to display employee details
    public void displayEmployeeDetails() {
        if (this instanceof Employee) {
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + this.name);
            System.out.println("Employee ID: " + this.id);
            System.out.println("Designation: " + this.designation);
        } else {
            System.out.println("Invalid employee object.");
        }
    }
    
    public static void main(String[] args) {
        Employee emp1 = new Employee("Alice Johnson", 101, "Software Engineer");
        Employee emp2 = new Employee("Bob Smith", 102, "Project Manager");
        
        emp1.displayEmployeeDetails();
        emp2.displayEmployeeDetails();
        
        displayTotalEmployees();
    }
}

