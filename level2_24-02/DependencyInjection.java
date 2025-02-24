import java.lang.annotation.*; 
import java.lang.reflect.*; 
import java.util.*; 
public class DependencyInjection{ 
public static void main(String[] args) throws Exception { 
DIContainer container = new DIContainer(); 
container.register(Service.class); 
Client client = new Client(); 
container.injectDependencies(client); 
client.execute(); 
} 
}
@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.FIELD) 
@interface Inject {} 
class DIContainer { 
private Map<Class<?>, Object> instances = new HashMap<>(); 
public <T> void register(Class<T> clazz) throws Exception { 
Constructor<T> constructor = clazz.getDeclaredConstructor(); 
constructor.setAccessible(true); 
T instance = constructor.newInstance(); 
instances.put(clazz, instance); 
} 
public void injectDependencies(Object object) throws Exception { 
for (Field field : object.getClass().getDeclaredFields()) { 
if (field.isAnnotationPresent(Inject.class)) { 
Class<?> fieldType = field.getType(); 
Object dependency = instances.get(fieldType); 
if (dependency == null) throw new RuntimeException("No registered instance for " + fieldType); 
field.setAccessible(true); 
field.set(object, dependency); 
} 
} 
} 
} 
class Service { 
void serve() { System.out.println("Service is running..."); } 
} 
class Client { 
@Inject private Service service; 
void execute() { 
service.serve(); 
} 
} 

