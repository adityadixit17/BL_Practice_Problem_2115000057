import java.io.*; 
import java.util.*; 
public class EmployeeManager { 
public static void main(String[] args) { 
List<Employee> employees = new ArrayList<>(); 
employees.add(new Employee(1, "Alice", "HR", 50000)); 
employees.add(new Employee(2, "Bob", "IT", 60000)); 
employees.add(new Employee(3, "Charlie", "Finance", 55000)); 

try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.dat"))) { 
oos.writeObject(employees); 
System.out.println("Employees serialized successfully."); 
} catch (IOException e) { 
System.out.println("Error: " + e.getMessage()); 
} 

try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.dat"))) { 
List<Employee> deserializedEmployees = (List<Employee>) ois.readObject(); 
System.out.println("Deserialized Employees:"); 
deserializedEmployees.forEach(System.out::println); 
} catch (IOException | ClassNotFoundException e) { 
System.out.println("Error: " + e.getMessage()); 
} 
} 
}

class Employee implements Serializable { 
private int id; 
private String name; 
private String department; 
private double salary; 

public Employee(int id, String name, String department, double salary) { 
this.id = id; 
this.name = name; 
this.department = department; 
this.salary = salary; 
} 

public String toString() { 
return "ID: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary; 
} 
} 
