import java.lang.reflect.*; 
public class JSONRepresentation{ 
public static void main(String[] args) throws IllegalAccessException { 
Person person = new Person(); 
System.out.println(JsonSerializer.toJson(person)); 
} 
}
class JsonSerializer { 
public static String toJson(Object obj) throws IllegalAccessException { 
StringBuilder json = new StringBuilder("{"); 
Field[] fields = obj.getClass().getDeclaredFields(); 
for (int i = 0; i < fields.length; i++) { 
fields[i].setAccessible(true); 
json.append("\"").append(fields[i].getName()).append("\":"); 
Object value = fields[i].get(obj); 
if (value instanceof String) json.append("\"").append(value).append("\""); 
else json.append(value); 
if (i < fields.length - 1) json.append(","); 
} 
json.append("}"); 
return json.toString(); 
} 
} 
class Person { 
private String name = "Alice"; 
private int age = 25; 
} 
