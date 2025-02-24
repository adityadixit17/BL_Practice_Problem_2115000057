import java.lang.reflect.*; 
public class ReflectionExample { 
public static void main(String[] args) throws Exception { 
Person p = new Person(25); 
Field field = Person.class.getDeclaredField("age"); 
field.setAccessible(true); 
System.out.println("Original Age: " + field.get(p)); 
field.set(p, 30); 
System.out.println("Modified Age: " + field.get(p)); 
} 
}
class Person { 
private int age; 
public Person(int age) { this.age = age; } 
public int getAge() { return age; } 
} 
