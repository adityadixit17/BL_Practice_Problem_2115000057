import java.lang.reflect.*; 
class Configuration { 
private static String API_KEY = "DEFAULT_KEY"; 
public static String getApiKey() { 
return API_KEY; 
} 
} 
public class StaticFields{ 
public static void main(String[] args) throws Exception { 
Field field = Configuration.class.getDeclaredField("API_KEY"); 
field.setAccessible(true); 
field.set(null, "NEW_SECRET_KEY"); 
System.out.println("Updated API_KEY: " + Configuration.getApiKey()); 
} 
}
