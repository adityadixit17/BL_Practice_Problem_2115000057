import java.lang.reflect.*; 
import java.util.*; 
public class CustomObjectMapper{ 
public static void main(String[] args) throws Exception { 
Map<String, Object> data = new HashMap<>(); 
data.put("name", "John"); 
data.put("age", 30); 
Person person = ObjectMapper.toObject(Person.class, data); 
System.out.println(person); 
} 
}
class ObjectMapper { 
public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) throws Exception { 
T instance = clazz.getDeclaredConstructor().newInstance(); 
for (Map.Entry<String, Object> entry : properties.entrySet()) { 
try { 
Field field = clazz.getDeclaredField(entry.getKey()); 
field.setAccessible(true); 
field.set(instance, entry.getValue()); 
} catch (NoSuchFieldException ignored) {} 
} 
return instance; 
} 
} 
class Person { 
private String name; 
private int age; 
public String toString() { 
return "Person{name='" + name + "', age=" + age + "}"; 
} 
} 
