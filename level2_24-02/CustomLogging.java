import java.lang.reflect.*; 
public class CustomLogging{ 
public static void main(String[] args) { 
Greeting greeting = (Greeting) Proxy.newProxyInstance( 
Greeting.class.getClassLoader(), 
new Class[]{Greeting.class}, 
new LoggingHandler(new GreetingImpl())); 
greeting.sayHello(); 
} 
}
interface Greeting { 
void sayHello(); 
} 
class GreetingImpl implements Greeting { 
public void sayHello() { 
System.out.println("Hello!"); 
} 
} 
class LoggingHandler implements InvocationHandler { 
private final Object target; 
public LoggingHandler(Object target) { 
this.target = target; 
} 
public Object invoke(Object proxy, Method method, Object[] args) throws Throwable { 
System.out.println("Invoking: " + method.getName()); 
return method.invoke(target, args); 
} 
} 
