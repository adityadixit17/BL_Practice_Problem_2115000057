import java.lang.reflect.*; 
public class ClassInfo { 
public static void main(String[] args) { 
Class<?> obj = Employee.class; 
System.out.println("Class Name: " + obj.getName()); 
System.out.println("\nFields:"); 
for (Field field : obj.getDeclaredFields()) System.out.println(field); 
System.out.println("\nConstructors:"); 
for (Constructor<?> constructor : obj.getDeclaredConstructors()) System.out.println(constructor); 
System.out.println("\nMethods:"); 
for (Method method : obj.getDeclaredMethods()) System.out.println(method); 
} 
} 
class Employee { 
String name; 
String ID; 
String dept; 
public Employee(String name, String ID, String dept) { 
this.name = name; 
this.dept = dept; 
this.ID = ID; 
} 
public void printName() { System.out.println(name); } 
public void printID() { System.out.println(ID); } 
public void printDept() { System.out.println(dept); } 
}
