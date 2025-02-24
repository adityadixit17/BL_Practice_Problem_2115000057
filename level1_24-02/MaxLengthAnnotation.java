import java.lang.annotation.*; 
import java.lang.reflect.*; 
public class MaxLengthAnnotation{ 
public static void main(String[] args) { 
new User("ShortName"); 
new User("ThisNameIsTooLong"); 
} 
}
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD) 
@interface MaxLength { 
int value(); 
} 
class User { 
@MaxLength(10) 
private String username; 
public User(String username) { 
this.username = username; 
validate(); 
} 
private void validate() { 
for (Field field : this.getClass().getDeclaredFields()) { 
if (field.isAnnotationPresent(MaxLength.class)) { 
MaxLength maxLength = field.getAnnotation(MaxLength.class); 
try { 
field.setAccessible(true); 
String value = (String) field.get(this); 
if (value.length() > maxLength.value()) { 
throw new IllegalArgumentException("Max length exceeded for field: " + field.getName()); 
} 
} catch (IllegalAccessException e) { 
e.printStackTrace(); 
} 
} 
} 
} 
} 

