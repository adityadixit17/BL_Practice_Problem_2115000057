import java.lang.annotation.*; 
import java.lang.reflect.*; 
import java.util.*; 
public class CacheResultAnnotation{ 
public static void main(String[] args) throws Exception { 
ExpensiveOperations obj = new ExpensiveOperations(); 
Method method = obj.getClass().getMethod("computeFactorial", int.class); 
System.out.println(CacheHandler.invoke(obj, method, 5)); 
System.out.println(CacheHandler.invoke(obj, method, 5)); 
System.out.println(CacheHandler.invoke(obj, method, 6)); 
} 
}
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
@interface CacheResult {} 
class CacheHandler { 
private static final Map<String, Object> cache = new HashMap<>(); 
public static Object invoke(Object obj, Method method, Object... args) throws Exception { 
if (method.isAnnotationPresent(CacheResult.class)) { 
String key = method.getName() + Arrays.toString(args); 
if (cache.containsKey(key)) return cache.get(key); 
Object result = method.invoke(obj, args); 
cache.put(key, result); 
return result; 
} 
return method.invoke(obj, args); 
} 
} 
class ExpensiveOperations { 
@CacheResult 
public int computeFactorial(int n) { 
if (n == 0) return 1; 
return n * computeFactorial(n - 1); 
} 
} 
