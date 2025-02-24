import java.lang.reflect.*; 
import java.util.*; 
public class DynamicMethodInvoke{ 
public static void main(String[] args) throws Exception { 
Scanner sc = new Scanner(System.in); 
System.out.print("Enter method name (add, subtract, multiply): "); 
String methodName = sc.next(); 
System.out.print("Enter two numbers: "); 
int num1 = sc.nextInt(); 
int num2 = sc.nextInt(); 
Class<?> cls = MathOperations.class; 
Object obj = cls.getDeclaredConstructor().newInstance(); 
Method method = cls.getMethod(methodName, int.class, int.class); 
Object result = method.invoke(obj, num1, num2); 
System.out.println("Result: " + result); 
} 
}
class MathOperations { 
public int add(int a, int b) { return a + b; } 
public int subtract(int a, int b) { return a - b; } 
public int multiply(int a, int b) { return a * b; } 
} 
