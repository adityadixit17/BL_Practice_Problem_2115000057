import java.lang.reflect.*; 
public class DynamicallyCreateObjects{ 
public static void main(String[] args) throws Exception { 
Class<?> cls = Class.forName("Student"); 
Object obj = cls.getDeclaredConstructor().newInstance(); 
Method method = cls.getMethod("display"); 
method.invoke(obj); 
} 
}
class Student { 
String name; 
public Student() { this.name = "Default Student"; } 
public void display() { System.out.println("Student Name: " + name); } 
} 
