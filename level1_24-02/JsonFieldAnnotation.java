import java.lang.annotation.*; 
import java.lang.reflect.*; 
import java.util.*; 
public class JsonFieldAnnotation{ 
public static void main(String[] args){ 
User user = new User("JohnDoe", 25); 
String json = JsonSerializer.serialize(user); 
System.out.println(json); 
} 
}
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD) 
@interface JsonField { 
String name(); 
} 
class User { 
@JsonField(name = "user_name") 
private String username; 
@JsonField(name = "user_age") 
private int age; 
public User(String username, int age) { 
this.username = username; 
this.age = age; 
} 
} 
class JsonSerializer { 
public static String serialize(Object obj) { 
try { 
Class<?> clazz = obj.getClass(); 
Map<String, String> jsonMap = new HashMap<>(); 
for (Field field : clazz.getDeclaredFields()) { 
field.setAccessible(true); 
if (field.isAnnotationPresent(JsonField.class)) { 
JsonField annotation = field.getAnnotation(JsonField.class); 
jsonMap.put(annotation.name(), field.get(obj).toString()); 
} 
} 
StringBuilder json = new StringBuilder("{"); 
for (Map.Entry<String, String> entry : jsonMap.entrySet()) { 
json.append("\"").append(entry.getKey()).append("\":\"") 
.append(entry.getValue()).append("\","); 
} 
if (json.length() > 1) json.deleteCharAt(json.length() - 1); 
json.append("}"); 
return json.toString(); 
} catch (Exception e) { 
e.printStackTrace(); 
} 
return "{}"; 
} 
} 
