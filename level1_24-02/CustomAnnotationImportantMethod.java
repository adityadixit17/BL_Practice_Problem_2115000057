import java.lang.annotation.*;
import java.lang.reflect.*;
public class CustomAnnotationImportantMethod {
public static void main(String[] args) {
try {
Class<MethodContainer> obj = MethodContainer.class;
for (Method method : obj.getDeclaredMethods()) {
if (method.isAnnotationPresent(ImportantMethod.class)) {
ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
}
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
String level() default "HIGH";
}
class MethodContainer{
@ImportantMethod(level = "HIGH")
public void criticalTask() {
System.out.println("Executing critical task...");
}
@ImportantMethod(level = "MEDIUM")
public void normalTask() {
System.out.println("Executing normal task...");
}
public void unimportantTask() {
System.out.println("This task is not important.");
}
}
